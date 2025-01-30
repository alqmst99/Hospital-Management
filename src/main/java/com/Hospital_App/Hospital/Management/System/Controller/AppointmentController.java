/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Appointment;

import com.Hospital_App.Hospital.Management.System.Services.AppointmentService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AppointmentService as;
    
    @PostMapping("/create")
    public Appointment saveAp(@RequestBody Appointment ap) {
        return as.createAppointment(ap);
    }
    
    @GetMapping
    public List<Appointment> getAllAppoint() {
        return as.getaAppointment();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getOneAppoint(@PathVariable long id)  {
        Appointment ap = as.getAppointmentById(id);
        return ap != null ? ResponseEntity.ok(ap) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppint(@PathVariable Long id) {
        //Find appointment wiht id
        Appointment ap = as.getAppointmentById(id);
        if (ap != null) {
            as.deleteAppointment(id);
        }
        
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppoint(@PathVariable Long id, @RequestBody Appointment a) {
        Appointment ap = as.getAppointmentById(id);
        if(ap!= null){
        Appointment saveA = as.UpdateAppoint(id, a);
        return ResponseEntity.ok(saveA);
        }
        return ResponseEntity.notFound().build();
        
    }
}
