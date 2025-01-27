/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.Repository;

import com.Hospital_App.Hospital.Management.System.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nahue
 */

@Repository
public interface MedicineRepo  extends JpaRepository<Medicine, Long>{
    
}
