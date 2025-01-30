/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hospital_App.Hospital.Management.System.Services;

import com.Hospital_App.Hospital.Management.System.Model.Appointment;
import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Repository.AppointmentRepo;
import com.Hospital_App.Hospital.Management.System.Repository.PatientRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@Service
@Transactional
public class PatientService {
    
    @Autowired
    private PatientRepo pr;
    
    @Autowired
    private AppointmentRepo ar;

    //Get all Patient
    public List<Patient> getAPatient() {
        return pr.findAll();
    }

    //Get One Patient by Id
    public Patient getPatientById(Long id) {
        return pr.findById(id).orElse(null);
    }

    //Create Patient
    public Patient createPatient(Patient p) {
        return pr.save(p);
    }

    //Get Appoinment by MedicId
    public List<Appointment> getAppointByPatientId(long patientId) {
        Patient p = pr.findById(patientId).orElseThrow(() -> new RuntimeException("Medic not found by Id" + patientId));
        return p.getAppointment();
    }

    //Update Patient by Id 
    public Patient updatePatient(Long id, Patient p) {
        Patient ap = getPatientById(id);
        
        ap.setAge(p.getAge());
        ap.setFirst_name(p.getFirst_name());
        ap.setBlood(p.getBlood());
        ap.setDose(p.getDose());
        ap.setFees(p.getFees());
        ap.setPrescription(p.getPrescription());
        ap.setAppointment(p.getAppointment());
        ap.setUrgency(p.getUrgency());
        
        return pr.save(ap);
        
    }

    //Delete Patient and Appointment by Id
    public void deletePatient(Long id) {
        //Deleted all Appointment asociated in Patient before deleted
        List<Appointment> a = getAppointByPatientId(id);
        ar.deleteAll(a);
        pr.deleteById(id);
    }
    
}
