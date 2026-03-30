package com.hosptal.menu;

import Main.Display;
import com.hosptal.dao.PatientDAO;

import java.util.Scanner;

public class PatientMenu {
    Display display=new Display();
    Scanner sc=new Scanner(System.in);
    PatientDAO patientDAO=new PatientDAO();
    public  void Patient(){
        while(true){
            display.DisplayPatint();
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    patientDAO.addPatient();
                    break;
                case 2:
                    patientDAO.viewAllPatint();
                    break;
                case 3:
                    patientDAO.searchPatient();
                    break;
                case 4:
                    patientDAO.updatePatient();
                    break;
                case 5:
                    patientDAO.deletePatient();
                    break;
                case 6:
                    System.out.println("Thank You....!");
                    return;
            }
        }
    }
}
