package com.ayush22csu041.model;
//AyushSehrawat
import java.util.Date;

public class Appointment {
    private int appointment_id;
    private int patient_id;
    private Date appointment_date;
    private String appointment_time;

    public Appointment() {
    }

    public Appointment(int appointment_id, int patient_id, Date appointment_date, String appointment_time) {
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }
}

