package Main;

import com.hosptal.dao.DoctorDAO;
import com.hosptal.dao.PatientDAO;
import com.hosptal.dp.DBConnection;
import com.hosptal.model.Doctor;
import com.hosptal.model.Patient;

import java.sql.*;
import java.util.Scanner;

public class Operation {
    Scanner sc=new Scanner(System.in);
    public void runAddMapPatient(){
        String sql="Select * from patient";
        try(Connection con= DBConnection.getConnection();
            Statement st=con.createStatement();){
            ResultSet res=st.executeQuery(sql);
            while(res.next()){
                PatientDAO.patientMap.put(res.getInt(1),new Patient(res.getString(2),res.getInt(3),res.getLong(4),res.getString(5)));
            }
        }
        catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public  void runAddMapDoctor(){
        String sql="select * from doctor";
        try(Connection con=DBConnection.getConnection();
             PreparedStatement ps=con.prepareStatement(sql);){
            ResultSet res=ps.executeQuery();
            while(res.next()) {
                DoctorDAO.doctorMap.put(res.getInt(1),new Doctor(res.getString(2),res.getString(3),res.getString(4)));
            }
        }
        catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void addDoctorHelper(){
        System.out.println("Enter Doctor Name: ");
        String name=sc.nextLine();
        System.out.println("Enter specialization:");
        String specialization=sc.nextLine();
        String status="Available";
        Doctor doctor=new Doctor(name,specialization,status);
        String sql="INSERT  INTO doctor(name,specialization) values(?,?)";
        String sql2="select id from doctor where name=? and specialization=?";
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);){
            ps.setString(1,name);
            ps.setString(2,specialization);
            int row=ps.executeUpdate();
            PreparedStatement ps2=con.prepareStatement(sql2);
            ps2.setString(1,name);
            ps2.setString(2,specialization);
            ResultSet res=ps2.executeQuery();
            if(res.next()){
                DoctorDAO.doctorMap.put(res.getInt(1),doctor);
                System.out.println("Doctor add Successfully...!");
            }
            else System.out.println("Doctor Not Add..........!");

        }
        catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void showAppointment(){
        String sql="select p.name,d.name,a.Appointment_date ,a.status ,row_number() over(partition by status) from appointment a join doctor d on a.doctor_id=d.id join patient p on a.patient_id=p.id;";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);){
            ResultSet res=ps.executeQuery();
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.printf("| %-20s | %-20s | %-20s | %-10s |\n",
                    "Patient Name", "Doctor Name", "Date & Time", "Status");
            System.out.println("-----------------------------------------------------------------------------------");

            while (res.next()) {
                System.out.printf("| %-20s | %-20s | %-20s | %-10s |\n",
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4));
            }

            System.out.println("-----------------------------------------------------------------------------------");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
           }
    }
}
