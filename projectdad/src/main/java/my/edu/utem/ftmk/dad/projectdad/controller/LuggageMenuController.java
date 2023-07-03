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
 * @author Izzat Rahimi
 * This class serves as a Menu controller for managing Luggages.
 *
 */
@Controller
public class LuggageMenuController {
	
	//without initialization for defaultURI, there will be whitelabel error 
	//for adding new luggage
	//hence, initialize variable defaultURI with URI Link
	private String defaultURI = "http://localhost:8080/projectdad/api/luggage";
	
	@GetMapping("/luggage/list")
	public String getLuggage(Model model) {
		
		//The URI for GET luggage
		String uri = "http://localhost:8080/projectdad/api/luggage";
		
		//Get a list luggage from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = 
				restTemplate.getForEntity(uri, Luggage[].class);
		
		//Parse JSON data to array of object
		Luggage Luggages[] = response.getBody();
		
		//Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(Luggages);
		
		//Attach list to a model as attribute
		model.addAttribute("Luggages",luggageList);
		
		return "luggages";
		
		
	}
	
	@RequestMapping("/luggage/save")
	public String updateLuggage (@ModelAttribute Luggage luggage) {
		
		//create new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//create request body
		HttpEntity<Luggage> request = new HttpEntity<Luggage>(luggage);
		
		String luggageResponse = "";
		
		if (luggage.getLuggageId()> 0) {
			//this block update a new luggage and
			
			//send request PUT
			restTemplate.put(defaultURI, request, Luggage.class);
			
		}else {
			//this block add a new order type 
			
			//send request as POST
			luggageResponse = restTemplate.postForObject
					(defaultURI, request, String.class);
			
		}
		
		System.out.println(luggageResponse);
		
		//redirect request to display a list of order type
		return "redirect:/luggage/list";
		
	}
	
	@GetMapping("/luggage/{luggage_id}")
	public String getLuggage (@PathVariable Integer luggage_id, Model model) {
		
		String pageTitle = "New Luggage";
		Luggage luggage = new Luggage();
		
		//This block get an luggage to be updated
		if (luggage_id > 0) {
			
			//generate new URI and append orderTypeId to it
			String uri = defaultURI + "/" + luggage_id;
			
			//get an order type from web service
			RestTemplate restTemplate = new RestTemplate();
			luggage = restTemplate.getForObject(uri, Luggage.class);
			
			//give a new title to the page
			pageTitle = "Edit Luggage";
		}
		
		//attach value to pass to front end
		model.addAttribute("luggage", luggage);
		model.addAttribute("pageTitle", pageTitle);
		
		return "luggageinfo";
		
	}
	
	@RequestMapping("/luggage/delete/{luggage_id}")
	public String deleteLuggage(@PathVariable Integer luggage_id) {
		
		//generate a new URI, similar to the mapping in OrderTypeRESTController
		String uri = defaultURI + "/{luggage_id}";
		
		//send a DELETE request and attach the value of the orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("luggage_id", Integer.toString
				(luggage_id)));
		
		return "redirect:/luggage/list";
		
	}

}
