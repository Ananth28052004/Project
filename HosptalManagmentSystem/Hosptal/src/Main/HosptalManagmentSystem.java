package Main;
import com.hosptal.menu.AppointmentMenu;
import com.hosptal.menu.DoctorMenu;
import com.hosptal.menu.PatientMenu;
import com.hosptal.menu.PatientMenu;
import java.util.Scanner;

public class HosptalManagmentSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Display d=new Display();
        PatientMenu patientMenu=new PatientMenu();
        DoctorMenu doctorMenu=new DoctorMenu();
        AppointmentMenu appointmentMenu=new AppointmentMenu();
        Operation operation=new Operation();
        operation.runAddMapPatient();
        operation.runAddMapDoctor();
        while(true){
            d.DisplayMain();
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    patientMenu.Patient();
                    break;
                case 2:
                    doctorMenu.doctor();
                    break;
                case 3:
                    appointmentMenu.appointment();
                    break;
                case 4:
                    operation.showAppointment();
                    break;
                case 5:
                    System.out.println("Thank You...!");
                    System.exit(0);
                default:
                    System.out.println("Please Enter Correct Option");
            }
        }
    }
}
