package com.ayush22csu041.controller;
//AyushSehrawat
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiagnosisController {

    private List<Diagnosis> diagnoses = new ArrayList<>(Arrays.asList(
            new Diagnosis(1, "Common Cold", 100.00, 7, "Medication"),
            new Diagnosis(2, "Fractured Arm", 500.00, 14, "Surgery"),
            new Diagnosis(3, "Pneumonia", 1000.00, 21, "Hospitalization"),
            new Diagnosis(4, "Appendicitis", 2000.00, 10, "Surgery"),
            new Diagnosis(5, "Migraine", 300.00, 3, "Medication"),
            new Diagnosis(6, "Dengue Fever", 1500.00, 14, "Hospitalization"),
            new Diagnosis(7, "Asthma", 800.00, 7, "Medication"),
            new Diagnosis(8, "Diabetes", 1200.00, 30, "Medication")
    ));

    @GetMapping("/diagnoses")
    public List<Diagnosis> getAllDiagnoses() {
        return diagnoses;
    }

    @GetMapping("/diagnoses/{diagnosis_id}")
    public Diagnosis getDiagnosisById(@PathVariable int diagnosis_id) {
        return diagnoses.stream()
                .filter(diagnosis -> diagnosis.getDiagnosis_id() == diagnosis_id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/diagnoses")
    public String createDiagnosis(@RequestBody Diagnosis diagnosis) {
        diagnoses.add(diagnosis);
        return "Diagnosis added successfully";
    }

    @PutMapping("/diagnoses/{diagnosis_id}")
    public String updateDiagnosis(@PathVariable int diagnosis_id, @RequestBody Diagnosis updatedDiagnosis) {
        Diagnosis diagnosis = diagnoses.stream()
                .filter(d -> d.getDiagnosis_id() == diagnosis_id)
                .findFirst()
                .orElse(null);

        if (diagnosis != null) {
            diagnosis.setName(updatedDiagnosis.getName());
            diagnosis.setEstimated_cost(updatedDiagnosis.getEstimated_cost());
            diagnosis.setRecovery_time(updatedDiagnosis.getRecovery_time());
            diagnosis.setTreatment_type(updatedDiagnosis.getTreatment_type());
            return "Diagnosis updated successfully";
        } else {
            return "Diagnosis not found";
        }
    }

    @DeleteMapping("/diagnoses/{diagnosis_id}")
    public String deleteDiagnosis(@PathVariable int diagnosis_id) {
        Diagnosis diagnosis = diagnoses.stream()
                .filter(d -> d.getDiagnosis_id() == diagnosis_id)
                .findFirst()
                .orElse(null);

        if (diagnosis != null) {
            diagnoses.remove(diagnosis);
            return "Diagnosis deleted successfully";
        } else {
            return "Diagnosis not found";
        }
    }

    // Inner class representing Diagnosis entity
    private static class Diagnosis {
        private int diagnosis_id;
        private String name;
        private double estimated_cost;
        private int recovery_time;
        private String treatment_type;

        public Diagnosis() {
        }

        public Diagnosis(int diagnosis_id, String name, double estimated_cost, int recovery_time, String treatment_type) {
            this.diagnosis_id = diagnosis_id;
            this.name = name;
            this.estimated_cost = estimated_cost;
            this.recovery_time = recovery_time;
            this.treatment_type = treatment_type;
        }

        public int getDiagnosis_id() {
            return diagnosis_id;
        }

        public void setDiagnosis_id(int diagnosis_id) {
            this.diagnosis_id = diagnosis_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getEstimated_cost() {
            return estimated_cost;
        }

        public void setEstimated_cost(double estimated_cost) {
            this.estimated_cost = estimated_cost;
        }

        public int getRecovery_time() {
            return recovery_time;
        }

        public void setRecovery_time(int recovery_time) {
            this.recovery_time = recovery_time;
        }

        public String getTreatment_type() {
            return treatment_type;
        }

        public void setTreatment_type(String treatment_type) {
            this.treatment_type = treatment_type;
        }
    }
}
   
