package my.edu.utem.ftmk.dad.projectdad.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.projectdad.model.Checkpoint;

/**
 * @author Izzat Rahimi
 * This class serves as a Menu controller for managing Checkpoints.
 *
 */
@Controller
public class CheckpointMenuController {
	//without initialization for defaultURI, there will be whitelabel 
	//error for adding new checkpoint
	//hence, initialize variable defaultURI with URI Link
	private String defaultURI = 
			"http://localhost:8080/projectdad/api/checkpoint";
		
	@GetMapping("/checkpoint/list")
	public String getCheckpoint(Model model) {
			
		//The URI for GET checkpoint
		String uri = "http://localhost:8080/projectdad/api/checkpoint";
			
		//Get a list checkpoint from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint[]> response = 
				restTemplate.getForEntity(uri, Checkpoint[].class);
			
		//Parse JSON data to array of object
		Checkpoint Checkpoints[] = response.getBody();
			
		//Parse an array to a list object
		List<Checkpoint> checkpointList = Arrays.asList(Checkpoints);
			
		//Attach list to a model as attribute
		model.addAttribute("Checkpoints",checkpointList);
			
		return "checkpoints";
			
			
	}
		
	@RequestMapping("/checkpoint/save")
	public String updateCheckpoint (@ModelAttribute Checkpoint checkpoint) {
			
		//create new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
			
		//create request body
		HttpEntity<Checkpoint> request = new HttpEntity<Checkpoint>(checkpoint);
			
		String checkpointResponse = "";
			
		if (checkpoint.getCheckpointId()> 0) {
			//this block update a new checkpoint and
				
			//send request PUT
			restTemplate.put(defaultURI, request, Checkpoint.class);
				
		}else {
			//this block add a new checkpoint 
				
			//send request as POST
			checkpointResponse = restTemplate.postForObject
					(defaultURI, request, String.class);
				
		}
			
		System.out.println(checkpointResponse);
			
		//redirect request to display a list of checkpoint
		return "redirect:/checkpoint/list";
			
	}
		
	@GetMapping("/checkpoint/{checkpoint_id}")
	public String getCheckpoint 
	(@PathVariable Integer checkpoint_id, Model model) {
			
		String pageTitle = "New Checkpoint";
		Checkpoint checkpoint = new Checkpoint();
			
		//This block get an checkpoint to be updated
		if (checkpoint_id > 0) {
				
			//generate new URI and append checkpoint_id to it
			String uri = defaultURI + "/" + checkpoint_id;
				
			//get an checkpoint from web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoint = restTemplate.getForObject(uri, Checkpoint.class);
				
			//give a new title to the page
			pageTitle = "Edit Checkpoint";
		}
			
		//attach value to pass to front end
		model.addAttribute("checkpoint", checkpoint);
		model.addAttribute("pageTitle", pageTitle);
			
		return "checkpointinfo";
			
	}
		
	@RequestMapping("/checkpoint/delete/{checkpoint_id}")
	public String deleteCheckpoint(@PathVariable Integer checkpoint_id) {
			
		//generate a new URI, similar to the mapping in CheckpointRESTController
		String uri = defaultURI + "/{checkpoint_id}";
			
		//send a DELETE request and attach the value of the checkpoint_id into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("checkpoint_id", Integer.toString
				(checkpoint_id)));
			
		return "redirect:/checkpoint/list";
			
	}


}
