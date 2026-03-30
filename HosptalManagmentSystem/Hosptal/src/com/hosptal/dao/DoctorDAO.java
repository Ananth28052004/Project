package com.hosptal.dao;

import Main.Display;
import Main.Operation;
import com.hosptal.dp.DBConnection;
import com.hosptal.model.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DoctorDAO {
    public static Map<Integer, Doctor> doctorMap=new HashMap<>();
    Operation operation=new Operation();
    Scanner sc=new Scanner(System.in);
    Display display=new Display();
    public void addDoctor(){
        operation.addDoctorHelper();
    }
    public static void viewAllDoctor(){
        if(!doctorMap.isEmpty()){
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.printf("| %-15s | | %-20s | | %-25s | | %-20s |\n","Id","Doctor Name","Specialization","Status");
            System.out.println("---------------------------------------------------------------------------------------------------");
            for(var d:doctorMap.entrySet()){
                int key=d.getKey();
                Doctor value=d.getValue();
                System.out.printf("| %-15s | | %-20s | | %-25s | | %-20s |\n",
                        key,
                        value.getName(),
                        value.getSpecialization(),
                        value.getStatus());

            }
            System.out.println("---------------------------------------------------------------------------------------------------");

        }
        else System.out.println("No Doctor Found");
    }
    public void DeleteDoctor(){
        display.displayContinue();
        System.out.println("Enter Your Choice:");
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                break;
            case 2:
                return;
            default:
                System.out.println("Enter Correct Choice");
                return;
        }
        System.out.println("Enter Doctor Id:");
        int id=sc.nextInt();
        sc.nextLine();
        Doctor d=DoctorDAO.doctorMap.get(id);
        if(d==null){
            System.out.println("No Doctor Found this id");
            return;
        }
        String sql="delete from doctor where id=?";
        try(Connection con= DBConnection.getConnection();
            PreparedStatement pr=con.prepareStatement(sql);){
            pr.setInt(1,id);
            int row=pr.executeUpdate();
            if(row>0){
                DoctorDAO.doctorMap.remove(id);
                System.out.println("Delete Successfully...!");
            }
            else System.out.println("Doctor Not Delete...");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void updateDoctor(){
        viewAllDoctor();
        System.out.println("Enter Doctor id:");
        int id=sc.nextInt();
        sc.nextLine();
        Doctor d=DoctorDAO.doctorMap.get(id);
        if(d==null){
            System.out.println("Not Found Doctor");
            return;
        }
        display.updateDoctorDisplay();
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                System.out.println("Enter Name: ");
                String name=sc.nextLine();
                d.setName(name);
                String sql="update doctor set name=? where id=?";
                updateString(sql,name,id);
                break;

            case 2:
                System.out.println("Change specialization: ");
                String specialization=sc.nextLine();
                d.setSpecialization(specialization);
                sql="update doctor set specialization=? where id=?";
                updateString(sql,specialization,id);
                break;
            case 3:
                System.out.println("1.Avalable");
                System.out.println("2.Not Avalable");
                System.out.println();
                System.out.println("Enter Your Choice:");
                choice=sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1:
                        d.setStatus("Available");
                        updateString("update doctor set status=? where id=?","Available",id);
                        break;
                    case 2:
                        d.setStatus("Not Available");
                        updateString("update doctor set status=? where id=?","Not Available",id);
                        break;
                    default:
                        System.out.println("Please Enter Correct Choice");
                        return;
                }
                break;
            case 4:
                return;
            default:
                System.out.println("Please Enter Correct Choice");
                return;
        }
    }
    public void updateString(String sql,String name,int id){
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);){
            ps.setString(1,name);
            ps.setInt(2,id);
            int row=ps.executeUpdate();
            if(row>0){
                System.out.println("Name Update Successfully");
            }
            else System.out.println("Not Update");
        }
        catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
}
