package br.com.monitorsmiles.resource;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitorsmiles.domain.Flight;
import br.com.monitorsmiles.service.FlightService;

@CrossOrigin(origins = "*")
@RestController
public class FlightResource {
	
	@Autowired
	private FlightService flightService;
    
    @GetMapping(value = "/flights", produces = "application/json")
    public ResponseEntity<List<Flight>> myFlights(){
    	
        return ok(flightService.getFlightsFromCurrentUser());
    }
    
    

}
