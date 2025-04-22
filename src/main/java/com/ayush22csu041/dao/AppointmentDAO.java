package com.ayush22csu041.dao;
//AyushSehrawat
import java.util.List;
import com.ayush22csu041.model.Appointment;

public interface AppointmentDAO {
    int save(Appointment appointment);
    int update(Appointment appointment, int appointment_id);
    int delete(int appointment_id);
    List<Appointment> getAll();
    Appointment getById(int appointment_id);
}
