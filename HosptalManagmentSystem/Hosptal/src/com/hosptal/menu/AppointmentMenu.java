package com.hosptal.menu;

import Main.Display;
import com.hosptal.dao.AppoinmentDAO;

import java.util.Scanner;

public class AppointmentMenu {
    Scanner sc=new Scanner(System.in);
    Display display=new Display();
    AppoinmentDAO appoinmentDAO=new AppoinmentDAO();
    public void appointment(){
        while(true){
            display.displayAppointment();
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    appoinmentDAO.bookAppoinment();
                    break;
                case 2:
                    appoinmentDAO.displayAllAppoinment();
                    break;
                case 3:
                    appoinmentDAO.compliteAppointment();
                    break;
                case 4:
                    appoinmentDAO.pendingAppointment();
                    break;
                case 5:
                    appoinmentDAO.cancelAppointment();
                    break;
                case 6:
                    appoinmentDAO.updateStatus();
                    break;
                case 7:
                    return;
            }
        }
    }
}
