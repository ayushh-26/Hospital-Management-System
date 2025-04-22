package com.ayush22csu041.controller;
//AyushSehrawat
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ayush22csu041.dao.AppointmentDAO;
import com.ayush22csu041.model.Appointment;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    private AppointmentDAO appointmentDAO;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAll();
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable int id) {
        Appointment appointment = appointmentDAO.getById(id);
        if (appointment != null) {
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/appointments") // Ensure proper configuration for handling POST requests
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment) {
        int result = appointmentDAO.save(appointment);
        if (result != 0) {
            return new ResponseEntity<>("Appointment created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create appointment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
        int result = appointmentDAO.update(appointment, id);
        if (result != 0) {
            return new ResponseEntity<>("Appointment updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update appointment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int id) {
        int result = appointmentDAO.delete(id);
        if (result != 0) {
            return new ResponseEntity<>("Appointment deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete appointment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


