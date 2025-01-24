/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.DocLog.Controller;

import com.Hospital_App.Hospital.Management.System.DocLog.Model.Appointment;
import com.Hospital_App.Hospital.Management.System.DocLog.Repository.AppointmentRepo;
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
}
