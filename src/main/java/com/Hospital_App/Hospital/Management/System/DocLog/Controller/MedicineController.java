/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.DocLog.Controller;

import com.Hospital_App.Hospital.Management.System.DocLog.Model.Medicine;
import com.Hospital_App.Hospital.Management.System.DocLog.Repository.MedicineRepo;
import com.Hospital_App.Hospital.Management.System.Model.Patient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@RestController
@RequestMapping("/api/v1/medicine")
public class MedicineController {

    MedicineRepo mr;

    public MedicineController(MedicineRepo mr) {
        super();
        this.mr = mr;
    }

    @PostMapping("/create")
    public Medicine CreateMed(@RequestBody Medicine md) {
        return (mr.save(md));
    }

    @GetMapping
    public List<Medicine> getAllMed() {
        return mr.findAll();
    }
    
    @GetMapping( "/{id}")
    public ResponseEntity<Medicine> getOneMedicine(@PathVariable long id) throws AttributeNotFoundException {
        Medicine mp = mr.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient not found with id" + id));
return ResponseEntity.ok(mp);
    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable Long id) throws AttributeNotFoundException {
        //Find Medicine wiht id, or not exist lambda function throug error exception message
        Medicine ap = mr.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine not found with id" + id));
        mr.delete(ap);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine m) throws AttributeNotFoundException {
      Medicine md = mr.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine not found with id" + id));

        md.setDrugName(m.getDrugName());
        md.setStock(m.getStock());
   
        md.setId(m.getId());
        
       Medicine saveM= mr.save(md);
        return ResponseEntity.ok(saveM);
        
        
    }
}
