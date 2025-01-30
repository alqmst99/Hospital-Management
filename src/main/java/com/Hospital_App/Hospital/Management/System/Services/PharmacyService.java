

package com.Hospital_App.Hospital.Management.System.Services;

import com.Hospital_App.Hospital.Management.System.Model.Medic;
import com.Hospital_App.Hospital.Management.System.Model.Medicine;
import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Model.Pharmacy;
import com.Hospital_App.Hospital.Management.System.Repository.MedicineRepo;
import com.Hospital_App.Hospital.Management.System.Repository.PharmacyRepo;
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
public class PharmacyService {

    @Autowired
    private PharmacyRepo pr;
    
    @Autowired
    private MedicineRepo mr;
    
    //Get All pharmacies
    public List<Pharmacy> getAllPharmacies(){
    return pr.findAll();
    }
    
    //Get One Pharmacy by Id
    public Pharmacy getPharmacyById(Long Id){
        return pr.findById(Id).orElse(null);
    }
    
    
    //Create Pharmacy
    public Pharmacy createPharmacy(Medic m, Patient p, Medicine md, int q){
        if(md.getStock() > q){
            throw new RuntimeException("Not enough stock for medicne " + md.getDrugName());
        }
 
        md.setStock(md.getStock()-q);
        mr.save(md);
        
        Pharmacy ph= new Pharmacy(m, p, md, q);
        return pr.save(ph);
        
        
    }
    
    //Update Pharmacy by Id
    public Pharmacy updatePharmacy(Long id, Pharmacy p){
        Pharmacy ph = getPharmacyById(id);
        ph.setMedic(p.getMedic());
        ph.setPatient(p.getPatient());
        ph.setMedicine(p.getMedicine());
        ph.setQuantity(p.getQuantity());
        return pr.save(ph);
    }
    
    //Update Stock Medicines
    
    //Delete Pharmacy by Id
    public void deletePharmacy(Long id){
        pr.deleteById(id);
    }
}
