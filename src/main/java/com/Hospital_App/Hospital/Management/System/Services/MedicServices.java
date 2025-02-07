package com.Hospital_App.Hospital.Management.System.Services;

import com.Hospital_App.Hospital.Management.System.Model.Appointment;
import com.Hospital_App.Hospital.Management.System.Model.Medic;
import com.Hospital_App.Hospital.Management.System.Repository.AppointmentRepo;
import com.Hospital_App.Hospital.Management.System.Repository.MedicRepo;
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
public class MedicServices {

    @Autowired
    private MedicRepo mr;

    @Autowired
    private AppointmentRepo ar;

    //Get all Medic
    public List<Medic> getAMedic() {
        return mr.findAll();
    }

    //Get One Medic by Id
    public Medic getMedicById(Long id) {
        return mr.findById(id).orElse(null);
    }

    //Create Medic
    public Medic createMedic(Medic m) {
        return mr.save(m);
    }

    //Get Appoinment by MedicId
    public List<Appointment> getAppointByMedicId(long medicId) {
        Medic m = mr.findById(medicId).orElseThrow(() -> new RuntimeException("Medic not found by Id" + medicId));
        return m.getAppointment();
    }

    //Update Medic by Id
    public Medic updateMedic(Long id, Medic m) {
        Medic existM = getMedicById(id);
        existM.setNameDoc(m.getNameDoc());
        existM.setEspeciality(m.getEspeciality());
        existM.setAppointment(m.getAppointment());

        return mr.save(existM);
    }

    //Delete Medic by Id
    public void DeleteMedicById(Long id) {
        //validate that the medic have appointment relese before delete
        List<Appointment> a = getAppointByMedicId(id);

        if (!a.isEmpty()) {
            throw new RuntimeException("Cannot delete medic with  active appointment");
        }
        mr.deleteById(id);
    }

}
