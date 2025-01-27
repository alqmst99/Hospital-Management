
package com.Hospital_App.Hospital.Management.System.Model;

import jakarta.persistence.Column;
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
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="drug_name")
    private String drugName;
    
    @Column(name="stock")
    private int stock;
    
    @ManyToOne
    @JoinColumn(name="medico_id", nullable = false)
    private Medic medic;
    
     @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
    
    //Constructor void and complete

    public Medicine() {
    }

  
    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }
    
    
    
}
