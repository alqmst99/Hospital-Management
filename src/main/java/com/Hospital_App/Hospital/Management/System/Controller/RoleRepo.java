
package com.Hospital_App.Hospital.Management.System.Controller;

import com.Hospital_App.Hospital.Management.System.Enum.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nahuel N Pierini
 * @enterprise FSTailSolutioN
 */
public interface RoleRepo extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
