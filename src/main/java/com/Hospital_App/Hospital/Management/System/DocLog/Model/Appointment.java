
package com.Hospital_App.Hospital.Management.System.DocLog.Model;

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

@Entity(name= "appoinments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    
    @Column(name ="name")
    private String name;
    
    @Column(name="age")
    private int age;
    
    @Column(name="symtomps")
    private String symptomps;
    
    @Column(name="number")
    private int number;
    
    //Contructor void  and complete 

    public Appointment() {
    }

    public Appointment(long id, String name, int age, String symptoms, int number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.symptomps = symptoms;
        this.number = number;
    }
    
    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSymptoms() {
        return symptomps;
    }

    public void setSymptoms(String symptoms) {
        this.symptomps = symptoms;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
            
          
    
}
