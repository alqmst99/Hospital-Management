

package com.Hospital_App.Hospital.Management.System.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.management.relation.Role;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */

@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "user_name",nullable = false, unique = true)
    private String username;
    
   // @Column(name= "password", nullable = false, unique = true)
    
   /* @Enumerated(EnumType.STRING)
    private Role role;*/
    
    //constructor void and complete

    public User() {
    }

    public User(long id, String username, Role role) {
        this.id = id;
        this.username = username;
        //this.role = role;
    }
    
    //Getter and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }*/
    
    
    
}
