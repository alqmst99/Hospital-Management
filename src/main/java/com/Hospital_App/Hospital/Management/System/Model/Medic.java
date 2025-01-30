
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
@Table(name ="medic")
public class Medic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name_doc", nullable = false)
    private String nameDoc;
    
    @Column(name = "mat")
    private int mat;
    
    @Column(name = "especiality")
    private String especiality;
    
    @OneToMany(mappedBy = "medic", cascade = CascadeType.ALL, orphanRemoval = true )
    @JsonIgnore
    private List<Appointment> appointment;
    
  
    
    
    //Contructor void and Complete

    public Medic() {
    }

    
    
    
    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDoc() {
        return nameDoc;
    }

    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }



    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
    }

   
    
    
}
