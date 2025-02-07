
package com.Hospital_App.Hospital.Management.System.Repository;

import com.Hospital_App.Hospital.Management.System.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nahue
 */

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{
     Patient findByDni(String dni);
}
