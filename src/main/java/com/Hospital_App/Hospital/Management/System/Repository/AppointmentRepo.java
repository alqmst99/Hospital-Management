
package com.Hospital_App.Hospital.Management.System.Repository;

import com.Hospital_App.Hospital.Management.System.Model.Appointment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nahue
 */

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long>{


    
}
