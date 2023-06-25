package my.edu.utem.ftmk.dad.projectdad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.projectdad.model.Luggage;

/**
 * @author Izzat. Arif, Bashyar
 * The LuggageRepository interface provides the database operations for the Luggage entity.
 * It extends the JpaRepository interface, which provides basic CRUD operations for entities.
 * The LuggageRepository interface is annotated with @Repository to indicate that it is a repository component.
 */
@Repository
public interface LuggageRepository extends JpaRepository<Luggage, Long> {

}
