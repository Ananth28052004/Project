package com.hosptal.dao;

import com.hosptal.dp.DBConnection;
import com.hosptal.model.Appointment;
import com.hosptal.model.Doctor;

import java.sql.*;
import java.util.Scanner;

public class AppoinmentDAO {
    Scanner sc=new Scanner(System.in);
        public void bookAppoinment(){
            PatientDAO.viewAllPatint();
            System.out.println("Enter Patient Id: ");
            int patient_id=sc.nextInt();
            sc.nextLine();
            if(PatientDAO.patientMap.get(patient_id)==null){
                System.out.println("Patient Not Found");
                return;
            }
            DoctorDAO.viewAllDoctor();
            System.out.println("Enter Doctor Id:");
            int doctor_id=sc.nextInt();
            sc.nextLine();
            if(DoctorDAO.doctorMap.get(doctor_id)==null){
                System.out.println("Doctor Not Found");
                return;
            }
            Doctor d=DoctorDAO.doctorMap.get(doctor_id);
            if(d.getStatus().equals("Not Available")){
                System.out.println("Doctor is Not Avalable....");
                return;
            }
            System.out.println("Date like(YYYY-MM-DD HH:MM:SS) :");
            String date=sc.nextLine();
            Timestamp t=Timestamp.valueOf(date);
            Appointment appointment=new Appointment(patient_id,doctor_id,date,"pending");
            String sql="INSERT into appointment (patient_id,doctor_id,Appointment_date) values (?,?,?)";
            try(Connection con= DBConnection.getConnection();
                PreparedStatement pr=con.prepareStatement(sql);){

                pr.setInt(1,patient_id);
                pr.setInt(2,doctor_id);
                pr.setTimestamp(3,t);
                int row=pr.executeUpdate();
                if(row>0)System.out.println("Appoinment Successfully...!");
                else System.out.println("Not Found.......");
            }
            catch (SQLException e){
                System.out.println("Error"+e.getMessage());
            }
        }
    public  void displayAllAppoinment(){
        String sql="Select * from appointment";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);){
            ResultSet res=ps.executeQuery();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-15s | | %-15s | | %-15s | | %-35s | %-20s | \n","Id","Patient Id","Doctor Id","Appoinment Date","Status");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            while(res.next()){
                System.out.printf("| %-15s | | %-15s | | %-15s | | %-35s | %-20s | \n",
                        res.getInt(1),
                        res.getInt(2),
                        res.getInt(3),
                        res.getString(4),
                        res.getString(5));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public  void updateStatus(){
            displayAllAppoinment();
            System.out.println();
            System.out.println("Enter Appoinment Id: ");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("1.Pending");
            System.out.println("2.Complite");
            System.out.println("3.Cancel");
            System.out.println();
            System.out.println("Enter Your Choice:");
            int choice =sc.nextInt();
            sc.nextLine();
            String val="";
            if(choice==1)val="pending";
            else if(choice==2)val="complite";
            else if(choice==3)val="cancel";
            else {
                System.out.println("Please Enter Correct Choice");
                return;
            }
            String sql="Update appointment set status=? where id=?";
            try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);){
                ps.setString(1,val);
                ps.setInt(2,id);
                int row=ps.executeUpdate();
                if(row>0)System.out.println("Ststus Update Successfull");
                else System.out.println("Not Success");
            }
            catch (SQLException e){
                System.out.println("Error"+ e.getMessage());
            }
    }
    public  void compliteAppointment(){
        String sql="Select * from appointment where status='complite'";
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);) {
            ResultSet res = ps.executeQuery();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-15s | | %-15s | | %-15s | | %-35s | %-20s | \n", "Id", "Patient Id", "Doctor Id", "Appoinment Date", "Status");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            while (res.next()) {
                System.out.printf("| %-15s | | %-15s | | %-15s | | %-35s | %-20s | \n",
                        res.getInt(1),
                        res.getInt(2),
                        res.getInt(3),
                        res.getString(4),
                        res.getString(5));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void pendingAppointment(){
        String sql="Select * from appointment where status='pending'";
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);){
            ResultSet res=ps.executeQuery();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-15s | | %-15s | | %-15s | | %-35s | %-20s | \n","Id","Patient Id","Doctor Id","Appoinment Date","Status");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            while(res.next()){
                System.out.printf("| %-15s | | %-15s | | %-15s | | %-35s | %-20s | \n",
                        res.getInt(1),
                        res.getInt(2),
                        res.getInt(3),
                        res.getString(4),
                        res.getString(5));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void cancelAppointment(){
        String sql="Select * from appointment where status='cancel'";
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);){
            ResultSet res=ps.executeQuery();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-15s | | %-15s | | %-15s | | %-35s | %-20s | \n","Id","Patient Id","Doctor Id","Appoinment Date","Status");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            while(res.next()){
                System.out.printf("| %-15s | | %-15s | | %-15s | | %-35s | %-20s | \n",
                        res.getInt(1),
                        res.getInt(2),
                        res.getInt(3),
                        res.getString(4),
                        res.getString(5));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
}
