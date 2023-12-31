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

import my.edu.utem.ftmk.dad.projectdad.model.Checkpoint;
import my.edu.utem.ftmk.dad.projectdad.repository.CheckpointRepository;

/**
 * @author Izzat Rahimi
 * This class serves as a REST controller for managing Checkpoints.
 * It handles various HTTP requests related to checkpoints.
 *
 */
@RestController
@RequestMapping("/api/checkpoint")

//This code will function as REST controller for Checkpoint

public class CheckpointRESTController {
	
	@Autowired
	private CheckpointRepository checkpointRepository;
	
	
	/**
	 * GET request to retrieve all checkpoints.
	 * 
	 * @return List of all checkpoints
	 */
	@GetMapping
	public List<Checkpoint>getCheckpoint() {
		return checkpointRepository.findAll();
	}
	
	/**
	 * GET request to retrieve a specific checkpoint by its ID.
	 * @param id ID of the checkpoint to retrieve
	 * @return The requested checkpoint
	 */
	@GetMapping("{checkpoint_id}")
	public Checkpoint getCheckpoint(@PathVariable long checkpoint_id) {
		Checkpoint checkpoint = checkpointRepository.findById(checkpoint_id).get();
		
		return checkpoint;	
	}
	
	
	/**
	 * POST request to insert a new checkpoint.
	 * @param checkpoint Checkpoint object to insert
	 * @return The inserted checkpoint
	 */
	@PostMapping()
	public Checkpoint insertCheckpoint(@RequestBody Checkpoint checkpoint) {
		return checkpointRepository.save(checkpoint);
	}
	
	
	/**
	 * PUT request to update an existing checkpoint.
	 * @param checkpoint Checkpoint object to update
	 * @return The updated checkpoint
	 */
	@PutMapping()
	public Checkpoint updateCheckpoint(@RequestBody Checkpoint checkpoint) {
		return checkpointRepository.save(checkpoint);
	}
	
	
	/**
	 * DELETE request to delete a checkpoint by its ID.
	 * @param id ID of the checkpoint to delete
	 * @return ResponseEntity with OK status
	 */
	@DeleteMapping("{checkpoint_id}")
	public ResponseEntity<HttpStatus> deleteCheckpoint
	(@PathVariable long checkpoint_id){
		checkpointRepository.deleteById(checkpoint_id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
