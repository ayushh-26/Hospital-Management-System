package com.ayush22csu041.dao;
//AyushSehrawat
import java.util.List;
import com.ayush22csu041.model.Patient;

public interface PatientDAO {
    int save(Patient patient);
    int update(Patient patient, int patient_id);
    int delete(int patient_id);
    List<Patient> getAll();
    Patient getById(int patient_id);
}
