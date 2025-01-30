package com.Hospital_App.Hospital.Management.System.Services;

import com.Hospital_App.Hospital.Management.System.Model.User;
import com.Hospital_App.Hospital.Management.System.Repository.UserRepo;
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
        return ur.save(u);
    }
    
    public Optional<User> findByUsername(String username){
        return ur.findByUsername(username);
    }
    
}
