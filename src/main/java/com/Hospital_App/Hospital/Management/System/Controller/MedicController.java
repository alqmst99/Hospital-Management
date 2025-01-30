/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Medic;
import com.Hospital_App.Hospital.Management.System.Services.MedicServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/medic")
public class MedicController {

    @Autowired
    MedicServices ms;

    @PostMapping("/create")
    public Medic saveM(@RequestBody Medic m) {
        return ms.createMedic(m);
    }

    @GetMapping
    public List<Medic> getAllAppoint() {
        return ms.getAMedic();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medic> getOneAppoint(@PathVariable long id) {
        Medic m = ms.getMedicById(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppint(@PathVariable Long id) {
        //Find appointment wiht id
        Medic m = ms.getMedicById(id);
        if (m != null) {
            ms.DeleteMedicById(id);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medic> updateAppoint(@PathVariable Long id, @RequestBody Medic m) {
        Medic mp = ms.getMedicById(id);

        if (mp != null) {

            Medic saveM = ms.updateMedic(id, m);
            return ResponseEntity.ok(saveM);
        }
        return ResponseEntity.notFound().build();

    }

}
