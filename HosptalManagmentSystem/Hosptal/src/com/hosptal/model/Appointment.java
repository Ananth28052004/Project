package com.hosptal.model;

public class Appointment {
    private int id;
    private int patient_id;
    private int doctor_id;
    private String appointment_date;
    private String status;
    public Appointment(int patient_id,int doctor_id,String appointment_date,String status){
        this.patient_id=patient_id;
        this.doctor_id=doctor_id;
        this.appointment_date=appointment_date;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
