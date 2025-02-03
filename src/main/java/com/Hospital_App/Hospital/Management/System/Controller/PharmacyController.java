/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Medic;
import com.Hospital_App.Hospital.Management.System.Model.Medicine;
import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Model.Pharmacy;
import com.Hospital_App.Hospital.Management.System.Services.PharmacyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@RestController
@RequestMapping("/api/v1/pharmacy")
@Tag(name = "Pharmacy", description = "Pharmacy management")
@SecurityRequirement(name = "BararAuth")
public class PharmacyController {
 @Autowired
    PharmacyService ms;

    @PostMapping("/create")
        @Operation(summary = "Create a new Pharmacy")
    @ApiResponse(responseCode = "201",description = "Pharmacy successfully created")
    public ResponseEntity<Pharmacy> saveM(@RequestParam Long medicId, @RequestParam Long patientId, @RequestParam Long medicineId, @RequestParam int q) {
       Medic m= new Medic();
       m.setId(medicId);
       
       Patient p= new Patient();
       p.setId(patientId);
       
        Medicine md= new Medicine();
        md.setId(medicineId);
        
        Pharmacy ph= ms.createPharmacy(m, p, md, q);
        
        return ResponseEntity.ok(ph);
       
    }

    @GetMapping
        @Operation(summary = "Get All Pharmacy")
    @ApiResponse(responseCode = "200",description = "Pharmacy successfully get list")
    public List<Pharmacy> getAllAppoint() {
        return ms.getAllPharmacies();
    }

    @GetMapping("/{id}")
      @Operation(summary = "Get All Pharmacy")
    @ApiResponse(responseCode = "200", description = "Successful Pharmacy list")
    public ResponseEntity<Pharmacy> getOneAppoint(@PathVariable long id) {
        Pharmacy m = ms.getPharmacyById(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
     @Operation(summary = "Delete Pharmacy by Id")
    @ApiResponse(responseCode = "204", description = "Successful Pharmacy delete")
    public ResponseEntity<Void> deleteAppint(@PathVariable Long id) {
        //Find appointment wiht id
        Pharmacy m = ms.getPharmacyById(id);
        if (m != null) {
            ms.deletePharmacy(id);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
      @Operation(summary = "Update Pharmacy by id")
    @ApiResponse(responseCode = "200", description = "Successful Pharmacy Update")
    public ResponseEntity<Pharmacy> updateAppoint(@PathVariable Long id, @RequestBody Pharmacy m) {
        Pharmacy mp = ms.getPharmacyById(id);

        if (mp != null) {

           Pharmacy saveM = ms.updatePharmacy(id, m);
            return ResponseEntity.ok(saveM);
        }
        return ResponseEntity.notFound().build();

    }

}
