package com.ayush22csu041.model;
//AyushSehrawat
public class Patient {
    private int patient_id;
    private String name;
    private int age;
    private String phone_no;
    private String sex;
    private String blood_group;

   
    public Patient() {
    }

    public Patient(int patient_id, String name, int age, String phone_no, String sex, String blood_group) {
        this.patient_id = patient_id;
        this.name = name;
        this.age = age;
        this.phone_no = phone_no;
        this.sex = sex;
        this.blood_group = blood_group;
    }

   
    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }
}

