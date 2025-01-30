
package com.Hospital_App.Hospital.Management.System.Repository;

import com.Hospital_App.Hospital.Management.System.Model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nahue
 */
public interface UserRepo extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
}
