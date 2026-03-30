package Main;

public class Display {
    public void DisplayMain(){
        System.out.println("----Main Menu----");
        System.out.println("1.Patient Managment");
        System.out.println("2.Doctor Managment");
        System.out.println("3.Booking Appoinment");
        System.out.println("4.Show Appoinments");
        System.out.println("5.Exit");
        System.out.println();
        System.out.println("Enter Your Choice: ");
    }
    public void DisplayPatint(){
        System.out.println("------PATIENT MENU------");
        System.out.println("1.Add Patient");
        System.out.println("2.View All Patient");
        System.out.println("3.search Patient");
        System.out.println("4.Update Patient");
        System.out.println("5.Delete Patient");
        System.out.println("6.Back");
        System.out.println();
        System.out.println("Enter Your Choice: ");
    }
    public void displayDoctorMenu(){
        System.out.println("----DOCTOR MENU----");
        System.out.println("1.Add Doctor");
        System.out.println("2.View All Doctor");
        System.out.println("3.Update Doctor");
        System.out.println("4.Delect Doctor");
        System.out.println("5.Back");
        System.out.println();
        System.out.println("Enter Your Choice: ");

    }
    public  void updatePatientDisplay(){
        System.out.println("---Update---");
        System.out.println("1.Change Name");
        System.out.println("2.Change age");
        System.out.println("3.Change Phone No");
        System.out.println("4.Change Address");
        System.out.println("5.Back");
        System.out.println();
    }
    public void updateDoctorDisplay(){
        System.out.println("---Update---");
        System.out.println("1.Change Name");
        System.out.println("2.Change specialization");
        System.out.println("3.Change Status");
        System.out.println("4.Back");
        System.out.println();
        System.out.println("Enter Your Choice: ");

    }
    public void displayContinue(){
        System.out.println("1.Continue");
        System.out.println("2.Back");
        System.out.println();
    }
    public void displayAppointment(){
        System.out.println("----APPOINMENT MENU----");
        System.out.println("1.Book Appoinments");
        System.out.println("2.View All Appoinments");
        System.out.println("3.Complite Appoinments");
        System.out.println("4.Pending Appoinments");
        System.out.println("5.Cancal Appoinments");
        System.out.println("6.Update Status");
        System.out.println("7.Back");
        System.out.println();
        System.out.println("Enter Your Choice: ");
    }
}
