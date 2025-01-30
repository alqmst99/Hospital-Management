

package com.Hospital_App.Hospital.Management.System.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@Entity
@Table(name ="pharmacy")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
  @ManyToOne
  @JoinColumn(name = "medic_id", nullable = false)
  @JsonIgnore
  private Medic medic;
  
  @ManyToOne
  @JoinColumn(name = "patient_id", nullable = false)
  @JsonIgnore
  private Patient patient;
  
  @ManyToOne
  @JoinColumn(name = "Medicine_id", nullable = false)
  private Medicine medicine;
  
  @JoinColumn(name = "quantity")
  private int quantity;

   
    
 
    //Contructor void

    public Pharmacy(Medic m, Patient p, Medicine md, int q) {
    }

    public Pharmacy(Long id, Medic medic, Patient patient, Medicine medicine, int quantity) {
        this.id = id;
        this.medic = medic;
        this.patient = patient;
        this.medicine = medicine;
        this.quantity = quantity;
    }
    
    
    //Getters and Setters
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Method minus stock
    public boolean reduceStock(int q) {
        if(this.quantity >= q){
            this.quantity -= q;
            return true;
        }
        return false;
    }
    
}
