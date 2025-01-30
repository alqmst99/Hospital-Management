
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
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="drug_name")
    private String drugName;
    
    @Column(name="stock")
    private int stock;
    

  
    
    //Constructor void and complete

    public Medicine() {
    }

    public Medicine(long id, String drugName, int stock) {
        this.id = id;
        this.drugName = drugName;
        this.stock = stock;
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

  
    
}
