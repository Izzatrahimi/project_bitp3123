package my.edu.utem.ftmk.dad.projectdad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.projectdad.model.TrackingSheet;

/**
 * Repository interface for accessing and manipulating TrackingSheet entities in the database.
 */
@Repository
public interface TrackingSheetRepository extends JpaRepository<TrackingSheet, Long> { 


}
