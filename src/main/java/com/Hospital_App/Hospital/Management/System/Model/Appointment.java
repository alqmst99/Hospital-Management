
package com.Hospital_App.Hospital.Management.System.Model;

import com. Hospital_App.Hospital.Management.System.Model.Medic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



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
    
    @Column(name ="fecha")
    private String date;
    
    @Column(name="hora")
    private String hour;
    
    @Column(name="symtomps")
    private String symptomps;
    
    @Column(name="contact")
    private int contact;
    
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
   private Medic medic;
    
     @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
     private Patient patient;


    //Contructor void  and complete 

    public Appointment() {
    }

   
    
    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getSymptomps() {
        return symptomps;
    }

    public void setSymptomps(String symptomps) {
        this.symptomps = symptomps;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

   
            
          
    
}
