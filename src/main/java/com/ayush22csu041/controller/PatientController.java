package com.ayush22csu041.controller;
//AyushSehrawat
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ayush22csu041.dao.PatientDAO;
import com.ayush22csu041.model.Patient;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientDAO patientDAO;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientDAO.getAll();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
        Patient patient = patientDAO.getById(id);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/patients")
    public ResponseEntity<String> createPatient(@RequestBody Patient patient) {
        if (patientDAO.save(patient) != 0) {
            return new ResponseEntity<>("Patient created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create patient", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        if (patientDAO.update(patient, id) != 0) {
            return new ResponseEntity<>("Patient updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update patient", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        if (patientDAO.delete(id) != 0) {
            return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete patient", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


