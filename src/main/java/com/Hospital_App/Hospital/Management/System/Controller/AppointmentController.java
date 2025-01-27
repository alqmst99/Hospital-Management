/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Appointment;
import com.Hospital_App.Hospital.Management.System.Repository.AppointmentRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.management.AttributeNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    AppointmentRepo ar;

    public AppointmentController(AppointmentRepo ar) {
        super();
        this.ar = ar;
    }

    @PostMapping("/create")
    public Appointment saveAp(@RequestBody Appointment ap) {
        return ar.save(ap);
    }

    @GetMapping
    public List<Appointment>getAllAppoint() {
        return ar.findAll();
    }
    
    @GetMapping( "/{id}")
    public ResponseEntity<Appointment> getOneAppoint(@PathVariable long id) throws AttributeNotFoundException {
        Appointment ap = ar.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient not found with id" + id));
return ResponseEntity.ok(ap);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppint(@PathVariable Long id) throws AttributeNotFoundException{
        //Find appointment wiht id, or not exist lambda function throug error exception message
   Appointment ap= ar.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appointment not found with id"+ id));
    ar.delete(ap);
    Map<String,Boolean> response = new HashMap<String, Boolean>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
    }
    
    @PutMapping("/update/{id}")
     public ResponseEntity<Appointment> updateAppoint(@PathVariable Long id, @RequestBody Appointment a) throws AttributeNotFoundException {
      Appointment ap = ar.findById(id).orElseThrow(() -> new AttributeNotFoundException("Appointment not found with id" + id));

        ap.setDate(a.getDate());
        ap.setHour(a.getHour());
        ap.setContact(a.getContact());
      
        ap.setContact(a.getContact());
        ap.setSymptomps(a.getSymptomps());
   
        ap.setId(a.getId());
        
       Appointment saveA= ar.save(ap);
        return ResponseEntity.ok(saveA);
        
        
    }
}
