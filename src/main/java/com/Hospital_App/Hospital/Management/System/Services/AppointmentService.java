
package com.Hospital_App.Hospital.Management.System.Services;

import com.Hospital_App.Hospital.Management.System.Model.Appointment;
import com.Hospital_App.Hospital.Management.System.Model.Medic;
import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Repository.AppointmentRepo;
import com.Hospital_App.Hospital.Management.System.Repository.MedicRepo;
import com.Hospital_App.Hospital.Management.System.Repository.PatientRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepo ar;

    @Autowired
    private MedicRepo mr;

    @Autowired
    private PatientRepo pr;

    //Get All Appointment
    public List<Appointment> getaAppointment() {
        return ar.findAll();
    }

    //Get one Appointment by Id
    public Appointment getAppointmentById(Long id) {
        return ar.findById(id).orElse(null);
    }

    //Create Appointment
  
    public Appointment createAppointment(Appointment a) {
        //validat that the medic and the patient exist before save
        Medic m = mr.findById(a.getMedic().getId())
                .orElseThrow(() -> new RuntimeException("Medic not ofund"));
        Patient p = pr.findById(a.getPatient().getId()).orElseThrow(() -> new RuntimeException("Patient not found"));

        a.setMedic(m);
        a.setPatient(p);
        return ar.save(a);

    }

    //update Appoinment
    public Appointment UpdateAppoint(Long id, Appointment a) {

        Appointment ap = getAppointmentById(id);

        ap.setDate(a.getDate());
        ap.setHour(a.getHour());
        ap.setContact(a.getContact());
        ap.setPatient(a.getPatient());
        ap.setMedic(a.getMedic());
        ap.setContact(a.getContact());
        ap.setSymptomps(a.getSymptomps());
        return ar.save(ap);

    }

    //Delete Appoiintment by Id
    public void deleteAppointment(Long id) {
        ar.deleteById(id);
    }
}
