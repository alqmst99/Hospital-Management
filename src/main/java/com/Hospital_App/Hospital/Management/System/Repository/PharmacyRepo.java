/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.Repository;

import com.Hospital_App.Hospital.Management.System.Model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nahue
 */
public interface PharmacyRepo extends JpaRepository<Pharmacy, Long>{
    
}
