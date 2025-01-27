

package com.Hospital_App.Hospital.Management.System.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

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
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medicine> medicine;
    
    //Contructor void

    public Pharmacy() {
    }

    public Pharmacy(Long id, String name, List<Medicine> medicine) {
        this.id = id;
        this.name = name;
        this.medicine = medicine;
    }
    
    
    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(List<Medicine> medicine) {
        this.medicine = medicine;
    }
    
    
}
