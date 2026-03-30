package com.hosptal.menu;

import Main.Display;
import com.hosptal.dao.DoctorDAO;

import java.util.Scanner;

public class DoctorMenu {
    Display display=new Display();
    DoctorDAO doctorDAO=new DoctorDAO();
    Scanner sc=new Scanner(System.in);
    public void doctor(){
        while(true){
            display.displayDoctorMenu();
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    doctorDAO.addDoctor();
                    break;
                case 2:
                    doctorDAO.viewAllDoctor();
                    break;
                case 3:
                    doctorDAO.updateDoctor();
                    break;
                case 4:
                    doctorDAO.DeleteDoctor();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Please Enter Correct Choice");
            }
        }
    }
}
