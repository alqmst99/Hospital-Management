/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.User;
import com.Hospital_App.Hospital.Management.System.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "User management by admin")
@SecurityRequirement(name = "BararAuth")
public class UserController {

    @Autowired
    private UserService us;
    
  

    @GetMapping
           @Operation(summary = "Get All User")
    @ApiResponse(responseCode = "200", description = "Successful User list")
     @PreAuthorize("hasRole('ADMIN')") // Solo ADMIN puede crear pacientes
    public List<User> getAllMed() {
        return us.getAUsers();
    }

    @GetMapping("/{id}")
             @Operation(summary = "Get One User by  Id")
    @ApiResponse(responseCode = "200", description = "Successful get User ")
     @PreAuthorize("hasRole('ADMIN')") // Solo ADMIN puede crear pacientes
    public ResponseEntity<User> getOneMedicine(@PathVariable long id) {
        User u = us.getUserById(id);
        return ResponseEntity.ok(u);
    }

    @DeleteMapping("/delete/{id}")
             @Operation(summary = "Delete User by Id")
    @ApiResponse(responseCode = "204", description = "Successful User delete")
     @PreAuthorize("hasRole('ADMIN')") // Solo ADMIN puede crear pacientes
    public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable Long id) {
        //Find Medicine wiht id, or not exist lambda function throug error exception message
        User user =us.getUserById(id);
        if (user != null) {
            us.deleteUser(id);
            Map<String, Boolean> response = new HashMap<String, Boolean>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
      @Operation(summary = "Update User by id")
    @ApiResponse(responseCode = "200", description = "Successful User Update")
    public ResponseEntity<User> updateMedicine(@PathVariable Long id, @RequestBody User u) {
        User user = us.getUserById(id);
        if (user != null) {
            User saveS = us.updateUser(id, u);
            return ResponseEntity.ok(saveS);
        }

        return ResponseEntity.noContent().build();

    }
    
    
    
}
