package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Services.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import javax.management.AttributeNotFoundException;
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
@RequestMapping("/api/v1/patient")
@Tag(name = "Patient", description = "patient management")
@SecurityRequirement(name = "BararAuth")
public class PatientController {

    @Autowired
    private PatientService ps;

    @PostMapping("/create")
    @Operation(summary = "Create a new patient")
    @ApiResponse(responseCode = "201",description = "Patient successfully created")
    public Patient createPatient(@RequestBody Patient p) {
        return ps.createPatient(p);
    }

    @GetMapping
    @Operation(summary = "Get All Patients")
    @ApiResponse(responseCode = "200", description = "Successful patient list")
    public List<Patient> getAllPatient() {
        return ps.getAPatient();
    }

    @GetMapping("/{id}")
     @Operation(summary = "Get One Patients by  Id")
    @ApiResponse(responseCode = "200", description = "Successful get patient ")
    public ResponseEntity<Patient> getOnePatient(@PathVariable long id) throws AttributeNotFoundException {
        Patient ap = ps.getPatientById(id);
        return ap != null ? ResponseEntity.ok(ap) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
     @Operation(summary = "Delete Patient by Id")
    @ApiResponse(responseCode = "204", description = "Successful patient delete")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) {
        //Find Patient wiht id, 
        ps.deletePatient(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
     @Operation(summary = "Update Patients by id")
    @ApiResponse(responseCode = "200", description = "Successful patient Update")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient pd) {
        Patient ap = ps.getPatientById(id);
        if (ap != null) {

            return ResponseEntity.ok(ps.updatePatient(id, ap));
        }
        return ResponseEntity.notFound().build();
    }

}
