package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Services.PatientService;
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
public class PatientController {

    @Autowired
    private PatientService ps;

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient p) {
        return ps.createPatient(p);
    }

    @GetMapping
    public List<Patient> getAllPatient() {
        return ps.getAPatient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getOnePatient(@PathVariable long id) throws AttributeNotFoundException {
        Patient ap = ps.getPatientById(id);
        return ap != null ? ResponseEntity.ok(ap) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) {
        //Find Patient wiht id, 
        ps.deletePatient(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient pd) {
        Patient ap = ps.getPatientById(id);
        if (ap != null) {

            return ResponseEntity.ok(ps.updatePatient(id, ap));
        }
        return ResponseEntity.notFound().build();
    }

}
