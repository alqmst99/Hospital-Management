package com.Hospital_App.Hospital.Management.System.Services;

import com.Hospital_App.Hospital.Management.System.Enum.Role;
import com.Hospital_App.Hospital.Management.System.Model.User;
import com.Hospital_App.Hospital.Management.System.Repository.UserRepo;
import java.util.Collections;
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
    
    public UserService (UserRepo ur){
        this.ur= ur;
        this.bc= new BCryptPasswordEncoder();
    }
    
    
    public User registerUser(User u){
        u.setPassword(bc.encode(u.getPassword()));
        if (u.getRoles() == null || u.getRoles().isEmpty()) {
        u.setRoles(Collections.singleton(Role.PATIENT)); // Puedes cambiar el rol por defecto
    }
        return ur.save(u);
    }
    
    public Optional<User> findByUsername(String username){
        return ur.findByUsername(username);
    }
    
}
