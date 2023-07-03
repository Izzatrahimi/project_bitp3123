package my.edu.utem.ftmk.dad.projectdad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.projectdad.model.Luggage;
import my.edu.utem.ftmk.dad.projectdad.repository.LuggageRepository;

/**
 * @author Izzat Rahimi
 * This code represents a REST controller for managing luggage.
 * It provides API endpoints for performing CRUD operations on luggage entities.
 * The controller handles incoming HTTP requests and delegates the processing 
 * to the appropriate methods.
 *
 */
@RestController
@RequestMapping("/api/luggage")

//This code will function as REST controller for Luggage

public class LuggageRESTController {
	
	@Autowired
	private LuggageRepository luggageRepository;
	
	/**
	 * GET endpoint to retrieve all luggage entities.
	 * Returns a list of all luggage entities stored in the database.
	 */
	@GetMapping
	public List<Luggage>getLuggage() {
		return luggageRepository.findAll();
	}
	
	/**
	 * GET endpoint to retrieve a specific luggage entity.
	 * Takes the ID of the luggage as a path variable and returns the 
	 * corresponding luggage entity.
	 */
	@GetMapping("{luggage_id}")
	public Luggage getLuggage(@PathVariable long luggage_id) {
		Luggage luggage = luggageRepository.findById(luggage_id).get();
		
		return luggage;	
	}
	
	/**
	 * POST endpoint to insert a new luggage entity.
	 * Takes a JSON payload in the request body containing the details 
	 * of the new luggage.
	 * Inserts the new luggage entity into the database and returns 
	 * the inserted luggage entity.
	 */
	@PostMapping()
	public Luggage insertLuggage(@RequestBody Luggage luggage) {
		return luggageRepository.save(luggage);
	}
	
	/**
	 * PUT endpoint to update an existing luggage entity.
	 * Takes a JSON payload in the request body containing 
	 * the updated details of the luggage.
	 * Updates the corresponding luggage entity in 
	 * the database and returns the updated luggage entity.
	 */
	@PutMapping()
	public Luggage updateLuggage(@RequestBody Luggage luggage) {
		return luggageRepository.save(luggage);
	}
	
	/**
	 * DELETE endpoint to delete a specific luggage entity.
	 * Takes the ID of the luggage as a path variable and 
	 * deletes the corresponding luggage entity from the database.
	 * Returns an HTTP response with the status OK 
	 * to indicate successful deletion.
	 */
	@DeleteMapping("{luggage_id}")
	public ResponseEntity<HttpStatus> deleteLuggage(@PathVariable long luggage_id){
		luggageRepository.deleteById(luggage_id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
