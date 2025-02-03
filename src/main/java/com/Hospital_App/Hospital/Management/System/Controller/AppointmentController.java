/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Appointment;

import com.Hospital_App.Hospital.Management.System.Services.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Appointment", description = "Appointment management")
@SecurityRequirement(name = "BararAuth")
public class AppointmentController {

    @Autowired
    AppointmentService as;
    
    @PostMapping("/create")
    @Operation(summary = "Create a new Appointment")
    @ApiResponse(responseCode = "201",description = "Appointment successfully created")
    public Appointment saveAp(@RequestBody Appointment ap) {
        return as.createAppointment(ap);
    }
    
    @GetMapping
       @Operation(summary = "Get All Appointment")
    @ApiResponse(responseCode = "200", description = "Successful Appointment list")
    public List<Appointment> getAllAppoint() {
        return as.getaAppointment();
    }
    
    @GetMapping("/{id}")
         @Operation(summary = "Get One Appointment by  Id")
    @ApiResponse(responseCode = "200", description = "Successful get Appointment ")
    public ResponseEntity<Appointment> getOneAppoint(@PathVariable long id)  {
        Appointment ap = as.getAppointmentById(id);
        return ap != null ? ResponseEntity.ok(ap) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
         @Operation(summary = "Delete Appointment by Id")
    @ApiResponse(responseCode = "200", description = "Successful Appointment delete")
    public ResponseEntity<Void> deleteAppint(@PathVariable Long id) {
        //Find appointment wiht id
        Appointment ap = as.getAppointmentById(id);
        if (ap != null) {
            as.deleteAppointment(id);
        }
        
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update/{id}")
      @Operation(summary = "Update Appointment by id")
    @ApiResponse(responseCode = "204", description = "Successful Appointment Update")
    public ResponseEntity<Appointment> updateAppoint(@PathVariable Long id, @RequestBody Appointment a) {
        Appointment ap = as.getAppointmentById(id);
        if(ap!= null){
        Appointment saveA = as.UpdateAppoint(id, a);
        return ResponseEntity.ok(saveA);
        }
        return ResponseEntity.notFound().build();
        
    }
}
