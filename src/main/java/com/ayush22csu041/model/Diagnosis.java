package com.ayush22csu041.model;
//AyushSehrawat
public class Diagnosis {
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


