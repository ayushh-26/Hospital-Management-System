package com.ayush22csu041.dao;
//AyushSehrawat
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ayush22csu041.model.Appointment;

@Repository
public class AppointmentDAOImp1 implements AppointmentDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Appointment appointment) {
        String query = "INSERT INTO appointment (appointment_id, patient_id, appointment_date, appointment_time) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(query, appointment.getAppointment_id(), appointment.getPatient_id(), appointment.getAppointment_date(), appointment.getAppointment_time());
    }

    @Override
    public int update(Appointment appointment, int appointmentId) {
        String query = "UPDATE appointment SET patient_id = ?, appointment_date = ?, appointment_time = ? WHERE appointment_id = ?";
        return jdbcTemplate.update(query, appointment.getPatient_id(), appointment.getAppointment_date(), appointment.getAppointment_time(), appointmentId);
    }

    @Override
    public int delete(int appointmentId) {
        String query = "DELETE FROM appointment WHERE appointment_id = ?";
        return jdbcTemplate.update(query, appointmentId);
    }

    @Override
    public List<Appointment> getAll() {
        String query = "SELECT * FROM appointment";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Appointment.class));
    }

    @Override
    public Appointment getById(int appointmentId) {
        String query = "SELECT * FROM appointment WHERE appointment_id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Appointment.class), appointmentId);
    }
}
