package my.edu.utem.ftmk.dad.projectdad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.projectdad.model.Checkpoint;

/**
 * @author Izzat Rahimi
 * This is a repository interface for managing Checkpoint entities.
 * It extends the JpaRepository interface, providing CRUD operations 
 * for Checkpoint entities.
 */
@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {

}
