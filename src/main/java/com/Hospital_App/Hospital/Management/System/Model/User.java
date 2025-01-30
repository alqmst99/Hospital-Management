

package com.Hospital_App.Hospital.Management.System.Model;

import com.Hospital_App.Hospital.Management.System.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;


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
    
    @Column(name = "password", nullable = false)
    private String password;
    
   // @Column(name= "password", nullable = false, unique = true)
    
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "user_rele", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    //constructor void and complete

    public User() {
    }

    public User(long id, String username,String password ,Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password= password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    
}
