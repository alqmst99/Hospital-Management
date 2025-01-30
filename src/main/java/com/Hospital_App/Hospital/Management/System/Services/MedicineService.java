/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.Services;

import com.Hospital_App.Hospital.Management.System.Model.Medicine;
import com.Hospital_App.Hospital.Management.System.Repository.MedicineRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@Service
@Transactional
public class MedicineService {

    @Autowired
    private MedicineRepo mr;



    //Get All Medicines
    public List<Medicine> getAMedicine() {
        return mr.findAll();
    }

    //Get one Medicine by Id
    public Medicine getMedicineById(Long id) {
        return mr.findById(id).orElse(null);
    }

    //create Medicine 
    public Medicine createMedicine(Medicine m) {

                return mr.save(m);
              
    }

    //Update Medicnes
    public Medicine UpdateMedicine(Long id, Medicine m) {
        Medicine existM = getMedicineById(id);
        existM.setDrugName(m.getDrugName());
        existM.setStock(m.getStock());
       
        return mr.save(existM);

    }

    
    //Delete Medicine by Id
    public void deleteMedicineById(Long id) {
        mr.deleteById(id);
    }
}
