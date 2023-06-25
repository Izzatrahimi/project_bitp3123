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

import my.edu.utem.ftmk.dad.projectdad.model.Staff;
import my.edu.utem.ftmk.dad.projectdad.repository.StaffRepository;

/**
 * @author Ariff, Izzat, Bashyar
 * This class serves as the REST controller for managing Staff entities.
 * It handles various HTTP requests related to Staff data.
 *
 */
@RestController
@RequestMapping("/api/staff")

//This code will function as REST controller for Staff

public class StaffRESTController {
	
	@Autowired
	private StaffRepository StaffRepository;
	
	/**
	 * Handles the GET request to retrieve all Staff records.
	 * @return List of Staff records
	 */
	@GetMapping
	public List<Staff>getStaff() {
		return StaffRepository.findAll();
	}
	
	/**
	 * Handles the GET request to retrieve a specific Staff record by its ID.
	 * @param Id The ID of the Staff record to retrieve
	 * @return The Staff record with the specified ID
	 */
	@GetMapping("{Id}")
	public Staff getStaff(@PathVariable long Id) {
		Staff staff = StaffRepository.findById(Id).get();
		
		return staff;	
	}
	
	/**
	 * Handles the POST request to insert a new Staff record.
	 * @param staff The Staff object to insert
	 * @return The inserted Staff record
	 */
	@PostMapping()
	public Staff insertStaff(@RequestBody Staff staff) {
		return StaffRepository.save(staff);
	}
	
	/**
	 * Handles the PUT request to update an existing Staff record.
	 * @param staff The updated Staff object
	 * @return The updated Staff record
	 */
	@PutMapping()
	public Staff updateStaff(@RequestBody Staff staff) {
		return StaffRepository.save(staff);
	}
	
	/**
	 * Handles the DELETE request to delete a Staff record by its ID.
	 * @param Id The ID of the Staff record to delete
	 * @return HTTP status indicating the success of the operation
	 */
	@DeleteMapping("{Id}")
	public ResponseEntity<HttpStatus> deleteStaff(@PathVariable long Id){
		StaffRepository.deleteById(Id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
