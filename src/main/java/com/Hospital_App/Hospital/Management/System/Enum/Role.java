/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Hospital_App.Hospital.Management.System.Enum;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@Entity
@Table(name = "role")
public class Role {

    private Long id;
    
    private String role;
    
    //Contructor vois and complete 

    public Role() {
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }
    
    
    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
