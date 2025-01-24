package com.Hospital_App.Hospital.Management.System.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */

@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name")
    private String first_name;
    
    @Column(name="age")
    private int age;
    
    @Column(name="blood")
    private String blood;
    
    @Column(name="prescription")
    private String prescription;
    
    @Column(name="dose")
    private String dose;
    
    @Column(name="fees")
    private String fees;
    
    @Column(name="urgency")
    private boolean urgency;
    
    
    //constructor void and complete

    public Patient() {
    }

    public Patient(Long id, String first_name, int age, String blood, String prescription,  String dose, String fees, boolean urgency) {
        this.id = id;
        this.first_name = first_name;
        this.age = age;
        this.blood = blood;
        this.prescription= prescription;
        this.dose = dose;
        this.fees = fees;
        this.urgency = urgency;
    }
    
    
    //Getter and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name =first_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    
    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public boolean getUrgency() {
        return urgency;
    }

    public void setUrgency(boolean urgency) {
        this.urgency = urgency;
    }
    
    
    
    
    
    
}
