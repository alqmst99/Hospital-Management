/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.DocLog.Controller;

import com.Hospital_App.Hospital.Management.System.DocLog.Model.Medicine;
import com.Hospital_App.Hospital.Management.System.DocLog.Repository.MedicineRepo;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
