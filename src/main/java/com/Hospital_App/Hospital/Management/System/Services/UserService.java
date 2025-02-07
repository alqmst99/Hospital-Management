package com.Hospital_App.Hospital.Management.System.Services;

import com.Hospital_App.Hospital.Management.System.Enum.Role;
import com.Hospital_App.Hospital.Management.System.Model.Medic;
import com.Hospital_App.Hospital.Management.System.Model.Patient;
import com.Hospital_App.Hospital.Management.System.Model.User;
import com.Hospital_App.Hospital.Management.System.Repository.MedicRepo;
import com.Hospital_App.Hospital.Management.System.Repository.PatientRepo;
import com.Hospital_App.Hospital.Management.System.Repository.UserRepo;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@Service
public class UserService {
    
    private final UserRepo ur;
    
    private final BCryptPasswordEncoder bc;
    
    private final PatientRepo pr;
    
    private final MedicRepo mr;
    
    public UserService(UserRepo ur, PatientRepo pr, MedicRepo mr) {
        this.ur = ur;
        this.bc = new BCryptPasswordEncoder();
        this.pr = pr;
        this.mr = mr;
    }
    
    public User registerUser(User u) {
        u.setPassword(bc.encode(u.getPassword()));
        if (u.getRoles() == null || u.getRoles().isEmpty()) {
            u.setRoles(Collections.singleton(Role.PATIENT));            
        }
        if (u.getRoles().contains(Role.PATIENT)) {
            
            Patient pa = pr.findByDni(u.getDni());
            
            if (pa != null) {
                pa.setUser(u);
                u.setP(pa);
            } else {
                throw new RuntimeException("Patient not found by dni");
            }
            
        } else if (u.getRoles().contains(Role.MEDIC)) {
            Medic m = mr.findByMatricula(u.getMatricula());
            
            if (m != null) {
                m.setUser(u);
                u.setM(m);
            } else {
                throw new RuntimeException("Not fount Medic by Matricula");
            }
        }        
        
        return ur.save(u);
    }
    
    public Optional<User> findByUsername(String username) {
        return ur.findByUsername(username);
    }
    
    public List<User> getAUsers() {
        return ur.findAll();
    }
    
    public User getUserById(Long id) {
        
        return ur.findById(id).orElse(null);
    }
    
    
     public User updateUser(Long id, User u) {
        User us = getUserById(id);
        us.setPassword(bc.encode(u.getPassword()));
        us.setMatricula(u.getMatricula());
        us.setDni(u.getDni());
        us.setRoles(u.getRoles());
         if (us.getRoles().contains(Role.PATIENT)) {
            
            Patient pa = pr.findByDni(u.getDni());
            
            if (pa != null) {
                pa.setUser(us);
                us.setP(pa);
            } else {
                throw new RuntimeException("Patient not found by dni");
            }
            
        } else if (us.getRoles().contains(Role.MEDIC)) {
            Medic m = mr.findByMatricula(u.getMatricula());
            
            if (m != null) {
                m.setUser(us);
                us.setM(m);
            } else {
                throw new RuntimeException("Not fount Medic by Matricula");
            }
        }        

        return ur.save(us);
    }
     
     public void deleteUser(Long id){
          ur.deleteById(id);
     }
}
