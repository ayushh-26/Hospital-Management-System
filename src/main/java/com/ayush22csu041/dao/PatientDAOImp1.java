package com.ayush22csu041.dao;
//AyushSehrawat
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ayush22csu041.model.Patient;

@Repository
public class PatientDAOImp1 implements PatientDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Patient patient) {
        String query = "INSERT INTO patient_info (patient_id, name, age, phone_no, sex, blood_group) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, patient.getPatient_id(), patient.getName(), patient.getAge(), patient.getPhone_no(), patient.getSex(), patient.getBlood_group());
    }

    @Override
    public int update(Patient patient, int patient_id) {
        String query = "UPDATE patient_info SET name = ?, age = ?, phone_no = ?, sex = ?, blood_group = ? WHERE patient_id = ?";
        return jdbcTemplate.update(query, patient.getName(), patient.getAge(), patient.getPhone_no(), patient.getSex(), patient.getBlood_group(), patient_id);
    }

    @Override
    public int delete(int patient_id) {
        String query = "DELETE FROM patient_info WHERE patient_id = ?";
        return jdbcTemplate.update(query, patient_id);
    }

    @Override
    public List<Patient> getAll() {
        String query = "SELECT * FROM patient_info";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Patient.class));
    }

    @Override
    public Patient getById(int patient_id) {
        String query = "SELECT * FROM patient_info WHERE patient_id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Patient.class), patient_id);
    }
}

