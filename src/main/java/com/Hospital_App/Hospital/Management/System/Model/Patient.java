package com.Hospital_App.Hospital.Management.System.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

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
    private int dose;
    
    @Column(name="fees")
    private double fees;
    
    @Column(name="urgency")
    private boolean urgency;
    
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Appointment> appointment;
    //constructor void and complete

    public Patient() {
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

    
    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public boolean getUrgency() {
        return urgency;
    }

    public void setUrgency(boolean urgency) {
        this.urgency = urgency;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }
    
    
    
    
    
    
}
