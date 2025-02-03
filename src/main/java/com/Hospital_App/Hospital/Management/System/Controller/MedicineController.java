package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Medicine;
import com.Hospital_App.Hospital.Management.System.Services.MedicineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/v1/medicine")
@Tag(name = "Appointment", description = "Appointment management")
@SecurityRequirement(name = "BararAuth")
public class MedicineController {

    @Autowired
    MedicineService mr;

    @PostMapping("/create")
    @Operation(summary = "Create a new patient")
    @ApiResponse(responseCode = "201",description = "Patient successfully created")
    public ResponseEntity<Medicine> CreateMed(@RequestBody Medicine md) {
         Medicine m =mr.createMedicine(md);

        return  ResponseEntity.ok( m);
    }

    @GetMapping
           @Operation(summary = "Get All Patients")
    @ApiResponse(responseCode = "200", description = "Successful patient list")
    public List<Medicine> getAllMed() {
        return mr.getAMedicine();
    }

    @GetMapping("/{id}")
             @Operation(summary = "Get One Patients by  Id")
    @ApiResponse(responseCode = "200", description = "Successful get patient ")
    public ResponseEntity<Medicine> getOneMedicine(@PathVariable long id) {
        Medicine mp = mr.getMedicineById(id);
        return ResponseEntity.ok(mp);
    }

    @DeleteMapping("/delete/{id}")
             @Operation(summary = "Delete Patient by Id")
    @ApiResponse(responseCode = "204", description = "Successful patient delete")
    public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable Long id) {
        //Find Medicine wiht id, or not exist lambda function throug error exception message
        Medicine ap = mr.getMedicineById(id);
        if (ap != null) {
            mr.deleteMedicineById(id);
            Map<String, Boolean> response = new HashMap<String, Boolean>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
      @Operation(summary = "Update Patients by id")
    @ApiResponse(responseCode = "200", description = "Successful patient Update")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine m) {
        Medicine md = mr.getMedicineById(id);
        if (md != null) {
            Medicine saveM = mr.UpdateMedicine(id, m);
            return ResponseEntity.ok(saveM);
        }

        return ResponseEntity.noContent().build();

    }
}
