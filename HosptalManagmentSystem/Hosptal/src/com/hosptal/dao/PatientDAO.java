package com.hosptal.dao;

import Main.Display;
import com.hosptal.dp.DBConnection;
import com.hosptal.model.Patient;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PatientDAO {
   public static Map<Integer,Patient> patientMap=new HashMap<>();
    Scanner sc=new Scanner(System.in);
    Display display=new Display();
    public void addPatient(){
        System.out.println("Enter Patient Name:");
        String name=sc.nextLine();
        System.out.println("Enter Age:");
        int age=sc.nextInt();
        System.out.println("Enter Phone no:");
        long phone=sc.nextLong();
        sc.nextLine();
        System.out.println("Enetr Address:");
        String address=sc.nextLine();
        Patient patient=new Patient(name,age,phone,address);
        String sql="insert into patient (name,age,phone,address) values(?,?,?,?)";
        String sql2="SELECT id  from patient where name=? and address=?";
        try(Connection con= DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1, patient.getName());
            ps.setInt(2,patient.getAge());
            ps.setLong(3,patient.getPhone());
            ps.setString(4,patient.getAddress());
            ps.executeUpdate();
            PreparedStatement ps2=con.prepareStatement(sql2);
            ps2.setString(1,patient.getName());
            ps2.setString(2, patient.getAddress());
            ResultSet res=ps2.executeQuery();
            if(res.next()){
            patientMap.put(res.getInt(1),patient);
            System.out.println("Patient Add Successfully...!");
            }
            System.out.println();
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }

    }
    public static void viewAllPatint(){
            if(!patientMap.isEmpty()) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-15s | %-20s | %-15s | %-22s | %-30s |\n","Id","Name","age","Phone No","Address");
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                for (var p : patientMap.entrySet()) {
                    Patient value = p.getValue();
                    int key = p.getKey();
                    System.out.printf("| %-15s | %-20s | %-15s | %-22s | %-30s\n",
                            key,value.getName(),value.getAge(),value.getPhone(),value.getAddress());
                }
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
            }
            else System.out.println("No Patient Found");
            System.out.println();
    }
    public  void searchPatient(){
        System.out.println("Enter Patient Id:");
        int id=sc.nextInt();
        sc.nextLine();
        Patient pa=patientMap.get(id);
        if(pa!=null){
            System.out.println("Id: " + id + "\t\t" + "Name: " + pa.getName() + "\t\t" + "Age: " + pa.getAge() + "\t\t" + "Phone No:" + pa.getPhone() + "\t\t" + "Address: " +pa.getAddress());
        }
        else System.out.println("No Patient Found");

    }
    public void updatePatient(){
        viewAllPatint();
        System.out.println("Enter Patient Id:");
        int id=sc.nextInt();
              sc.nextLine();
              Patient p=patientMap.get(id);
              if(p==null){
                  System.out.println("Patient Not Found");
                  return;
              }
            String sql="";
            display.updatePatientDisplay();
            System.out.println("Enter Your Choice:");
             int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter new Name:");
                    String name=sc.nextLine();
                    p.setName(name);
                    patientMap.put(id,p);
                    updateString("update patient set name=? where id=?",name,id);
                    break;
                case 2:
                    System.out.println("Enter new Age:");
                    int age=sc.nextInt();
                    sc.nextLine();
                    p.setAge(age);
                    patientMap.put(id,p);
                    updateInt("Update patient set age=? where id=?",age,id);
                    break;
                case 3:
                    System.out.println("Enter new Phone No: ");
                    long phone=sc.nextLong();
                    sc.nextLine();
                    p.setPhone(phone);
                    patientMap.put(id,p);
                    updateInt("update patient set phone=? where id=?",phone,id);
                    break;
                case 4:
                    System.out.println("Enter new Address:");
                    String address=sc.nextLine();
                    p.setAddress(address);
                    patientMap.put(id,p);
                    updateString("update patient set address=? where id=?",address,id);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Please enter Correct Choice...!1");
            }


    }
    public void deletePatient(){
        display.displayContinue();
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                break;
            case 2:
                return;
            default:
                System.out.println("Please Enter Correct Choice:");
                return;
        }
        System.out.println("Enter Patient id:");
        int id=sc.nextInt();
        sc.nextLine();
        String sql="delete from patient where id=?";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement pr=con.prepareStatement(sql)){
            pr.setInt(1,id);
            int row=pr.executeUpdate();
            if(row>0){
                patientMap.remove(id);
                System.out.println("Delete Successfull...!");
            }
            else System.out.println("No Patient Fount this id");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void updateInt(String sql,int val,int id){
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);){
            ps.setInt(1,val);
            ps.setInt(2,id);
            int row=ps.executeUpdate();
            if(row>0)System.out.println("Update Successfully...!");
            else System.out.println("Patient Id not Found");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void updateInt(String sql,long val,int id){
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);){
            ps.setLong(1,val);
            ps.setInt(2,id);
            int row=ps.executeUpdate();
            if(row>0)System.out.println("Update Successfully...!");
            else System.out.println("Patient Id not Found");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void updateString(String sql,String val,int id){
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);){
            ps.setString(1,val);
            ps.setInt(2,id);
            int row=ps.executeUpdate();
            if(row>0)System.out.println("Update Successfully...!");
            else System.out.println("Patient Id not Found");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
}
