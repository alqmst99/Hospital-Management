
package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Repository.PatientRepo;
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
@RequestMapping("/api/v1/patient")
public class PatientController {

 private PatientRepo pr;
 
 //generate constructor super class
 public PatientController(PatientRepo pr){
     super();
     this.pr= pr;
 }
 
 
 @PostMapping("/create")
 public Patient createPatient(@RequestBody Patient p){
     return pr.save(p);
 }
 
 @GetMapping
 public List<Patient>getAllPatient(){
     return pr.findAll();
 }
}
