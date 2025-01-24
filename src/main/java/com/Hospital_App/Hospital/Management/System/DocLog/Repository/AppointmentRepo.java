
package com.Hospital_App.Hospital.Management.System.DocLog.Repository;

import com.Hospital_App.Hospital.Management.System.DocLog.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nahue
 */

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long>{
    
}
