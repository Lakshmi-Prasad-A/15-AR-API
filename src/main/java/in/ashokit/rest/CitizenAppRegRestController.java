package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.CitizenApp;
import in.ashokit.service.CitizenAppRegService;

@RestController
public class CitizenAppRegRestController {

	@Autowired
	private CitizenAppRegService service;
	
	@PostMapping
	public ResponseEntity<String> registerCitzenApp(@RequestBody CitizenApp app){
		
		String response = service.registerCitzenApp(app);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	}
