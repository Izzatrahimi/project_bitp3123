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

import my.edu.utem.ftmk.dad.projectdad.model.TrackingSheet;
import my.edu.utem.ftmk.dad.projectdad.repository.TrackingSheetRepository;

/**
 * @author Arif, Izzat, Bashyar
 * This code represents a REST controller for Tracking Sheets.
 *
 */
@RestController
@RequestMapping("/api/trackingsheet")

public class TrackingSheetRESTController {

	@Autowired
	private TrackingSheetRepository trackingSheetRepository;
	
	/**
     * Retrieves all tracking sheets from the database.
     *
     * @return a list of tracking sheets
     */
	@GetMapping
	public List<TrackingSheet>getTrackingSheet() {
		return trackingSheetRepository.findAll();
	}
	
	/**
     * Retrieves a specific tracking sheet by its ID.
     *
     * @param id the ID of the tracking sheet to retrieve
     * @return the tracking sheet with the specified ID
     */
	@GetMapping("{Id}")
	public TrackingSheet getTrackingSheet(@PathVariable long Id) {
		TrackingSheet trackingsheet = trackingSheetRepository.findById(Id).get();
		
		return trackingsheet;	
	}
	
	 /**
     * Inserts a new tracking sheet into the database.
     *
     * @param trackingsheet the tracking sheet to insert
     * @return the inserted tracking sheet
     */
	@PostMapping()
	public TrackingSheet insertTrackingSheet(@RequestBody TrackingSheet trackingsheet) {
		return trackingSheetRepository.save(trackingsheet);
	}
	
	/**
     * Updates an existing tracking sheet in the database.
     *
     * @param trackingsheet the tracking sheet to update
     * @return the updated tracking sheet
     */
	@PutMapping()
	public TrackingSheet updateTrackingSheet(@RequestBody TrackingSheet trackingsheet) {
		return trackingSheetRepository.save(trackingsheet);
	}
	
	/**
     * Deletes a tracking sheet from the database by its ID.
     *
     * @param id the ID of the tracking sheet to delete
     * @return a ResponseEntity with the HTTP status of the operation
     */
	@DeleteMapping("{Id}")
	public ResponseEntity<HttpStatus> deleteTrackingSheet(@PathVariable long Id){
		trackingSheetRepository.deleteById(Id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
