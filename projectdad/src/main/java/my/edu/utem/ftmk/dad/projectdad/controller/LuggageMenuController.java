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

import my.edu.utem.ftmk.dad.projectdad.model.Luggage;

/**
 * @author Arif, Izzat, Bashyar
 *
 */
@Controller

public class LuggageMenuController {
	
	private String defaultURI = "http://localhost:8080/projectdad/api/luggage";
	
	@GetMapping("/luggage/list")
	public String getLuggage(Model model) {
		
		//The URI for GET order types
		String uri = "http://localhost:8080/projectdad/api/luggage";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = restTemplate.getForEntity(uri, Luggage[].class);
		
		//Parse JSON data to array of object
		Luggage luggage[] = response.getBody();
		
		//Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggage);
		
		//Attach list to a model as attribute
		model.addAttribute("luggage",luggageList);
		
		return "luggage";
		
	}
	
	@RequestMapping("/luggage/save")
	public String updateLuggage (@ModelAttribute Luggage luggage) {
		
		//create new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//create request body
		HttpEntity<Luggage> request = new HttpEntity<Luggage>(luggage);
		
		String luggageResponse = "";
		
		if (luggage.getLuggageId()> 0) {
			
			//send request PUT
			restTemplate.put(defaultURI, request, Luggage.class);
			
		}else {
			//this block add a new order type 
			
			//send request as POST
			luggageResponse = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(luggageResponse);
		
		//redirect request to display a list of order type
		return "redirect:/luggage/list";
	}
	
	@GetMapping("/luggage/{Id}")
	public String getLuggage (@PathVariable Integer Id, Model model) {
		
		String pageTitle = "New Luggage";
		Luggage luggage = new Luggage();
		
		//This block get an order type to be updated
		if (Id > 0) {
			
			//generate new URI and append orderTypeId to it
			String uri = defaultURI + "/" + Id;
			
			//get an order type from web service
			RestTemplate restTemplate = new RestTemplate();
			luggage = restTemplate.getForObject(uri, Luggage.class);
			
			//give a new title to the page
			pageTitle = "Edit Luggage Info";
		}
		
		//attach value to pass to front end
		model.addAttribute("luggage", luggage);
		model.addAttribute("pageTitle", pageTitle);
		
		return "luggageinfo";
	}
	
	@RequestMapping("/luggage/delete/{Id}")
	public String deleteLuggage(@PathVariable Integer Id) {
		
		//generate a new URI, similar to the mapping in OrderTypeRESTController
		String uri = defaultURI + "/{Id}";
		
		//send a DELETE request and attach the value of the orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("Id", Integer.toString(Id)));
		
		return "redirect:/luggage/list";
		
	}
	

}
