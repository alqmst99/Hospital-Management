
package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Model.Medic;
import com.Hospital_App.Hospital.Management.System.Services.MedicServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
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
@RequestMapping("/api/v1/medic")
@Tag(name = "Medic", description = "Medic management")
@SecurityRequirement(name = "BararAuth")
public class MedicController {

    @Autowired
    MedicServices ms;

    @PostMapping("/create")
    @Operation(summary = "Create a new Medic")
    @ApiResponse(responseCode = "201",description = "Medic successfully created")
             @PreAuthorize("hasRole('ADMIN')") // Solo ADMIN puede crear pacientes

    public Medic saveM(@RequestBody Medic m) {
        return ms.createMedic(m);
    }

    @GetMapping
    @Operation(summary = "Get All Medic")
    @ApiResponse(responseCode = "200", description = "Successful Medic list")
             @PreAuthorize("hasRole('ADMIN')") // Solo ADMIN puede crear pacientes

    public List<Medic> getAllAppoint() {
        return ms.getAMedic();
    }

    @GetMapping("/{id}")
     @Operation(summary = "Get One Medic by  Id")
    @ApiResponse(responseCode = "200", description = "Successful get Medic ")
             @PreAuthorize("hasRole('ADMIN')") // Solo ADMIN puede crear pacientes

    public ResponseEntity<Medic> getOneAppoint(@PathVariable long id) {
        Medic m = ms.getMedicById(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
     @Operation(summary = "Delete Medic by Id")
    @ApiResponse(responseCode = "204", description = "Successful Medic delete")
             @PreAuthorize("hasRole('ADMIN')") // Solo ADMIN puede crear pacientes

    public ResponseEntity<Void> deleteAppint(@PathVariable Long id) {
        //Find appointment wiht id
        Medic m = ms.getMedicById(id);
        if (m != null) {
            ms.DeleteMedicById(id);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")      @Operation(summary = "Update Medic by id")
    @ApiResponse(responseCode = "200", description = "Successful Medic Update")
         @PreAuthorize("hasRole('ADMIN')") // Solo ADMIN puede crear pacientes

    public ResponseEntity<Medic> updateAppoint(@PathVariable Long id, @RequestBody Medic m) {
        Medic mp = ms.getMedicById(id);

        if (mp != null) {

            Medic saveM = ms.updateMedic(id, m);
            return ResponseEntity.ok(saveM);
        }
        return ResponseEntity.notFound().build();

    }

}
