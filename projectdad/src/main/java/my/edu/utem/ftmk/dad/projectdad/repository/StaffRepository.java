package my.edu.utem.ftmk.dad.projectdad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.projectdad.model.Staff;

/**
 * @author Izzat. Arif, Izzat
 * Repository interface for Staff entity.
 * This interface extends the JpaRepository interface provided by Spring Data JPA.
 * It provides CRUD (Create, Read, Update, Delete) operations for Staff entities.
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
