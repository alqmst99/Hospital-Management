package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.DocLog.Model.Appointment;
import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Repository.PatientRepo;
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
@RequestMapping("/api/v1/patient")
public class PatientController {

    private PatientRepo pr;

    //generate constructor super class
    public PatientController(PatientRepo pr) {
        super();
        this.pr = pr;
    }

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient p) {
        return pr.save(p);
    }

    @GetMapping
    public List<Patient> getAllPatient() {
        return pr.findAll();
    }

    @GetMapping( "/{id}")
    public ResponseEntity<Patient> getOnePatient(@PathVariable long id) throws AttributeNotFoundException {
        Patient ap = pr.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient not found with id" + id));
return ResponseEntity.ok(ap);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) throws AttributeNotFoundException {
        //Find Patient wiht id, or not exist lambda function throug error exception message
        Patient ap = pr.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient not found with id" + id));
        pr.delete(ap);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient pd) throws AttributeNotFoundException {
        Patient ap = pr.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient not found with id" + id));

        ap.setAge(pd.getAge());
        ap.setFirst_name(pd.getFirst_name());
        ap.setBlood(pd.getBlood());
        ap.setDose(pd.getDose());
        ap.setFees(pd.getFees());
        ap.setPrescription(pd.getPrescription());
        ap.setUrgency(pd.getUrgency());
        ap.setId(pd.getId());

        Patient saveP = pr.save(ap);
        return ResponseEntity.ok(saveP);

    }

}
