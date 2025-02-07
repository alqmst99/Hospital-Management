

package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.User;
import com.Hospital_App.Hospital.Management.System.Segurity.JwtUtil;
import com.Hospital_App.Hospital.Management.System.Services.TokenBlackListService;
import com.Hospital_App.Hospital.Management.System.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "Auth manamegement")
public class AuthController {

    private final UserService us;
    private final JwtUtil ju;
    private final TokenBlackListService tb;
    
    
   
    
    
    public AuthController (UserService us, JwtUtil ju, TokenBlackListService tb){
        this.us= us;
        this.ju= ju;
        this.tb= tb;
    }
    
    
    @PostMapping("/register")
    @Operation(summary = "Register user and encript password")
    public User register(@RequestBody User u){
        return us.registerUser(u);
    }
    
    @PostMapping("/login")
    @Operation(summary = "Autenticar user y take token JWT")
    public Map<String, String> loginUser (@RequestBody Map<String, String> credentials){
        String username= credentials.get("username");
        String password= credentials.get("password");
        
        Optional<User> userOpt= us.findByUsername(username);
        
        if(userOpt.isPresent()){
            String token= ju.generateToken(username);
            return Map.of("token", token);
        } else{
            throw new RuntimeException("The User or password incorrects");
        }
    }
    
    
    @PostMapping("/logout")
    @Operation(summary = "Logout user and ivalidate token")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> logOut(@RequestHeader ("Authorization") String token){
        tb.invalidateToken(token);
        return ResponseEntity.ok("Logout success");
        
    }



}
