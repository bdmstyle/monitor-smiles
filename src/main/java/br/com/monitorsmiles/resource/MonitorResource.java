package br.com.monitorsmiles.resource;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitorsmiles.domain.Place;
import br.com.monitorsmiles.service.MonitoringService;

@CrossOrigin(origins = "*")
@RestController
public class MonitorResource {
	
	@Autowired
    private MonitoringService monitoringService;
    
    @GetMapping(value = "/monitor")
    public ResponseEntity<List<Place>> placesMonitored(){
        return ok(monitoringService.getPlacesMonitoredByCurrentUser());
    }
    
    @GetMapping(value = "/monitor/{placeId}")
    public ResponseEntity<String> monitorPlace(@PathVariable("placeId") Long placeId){
    	
    	monitoringService.monitorPlace(placeId);
    	
        return ok("placeId "+ placeId +" is Monitored");
    }
    
    @DeleteMapping(value = "/monitor/{placeId}")
    public ResponseEntity<String> unMonitorPlace(@PathVariable("placeId") Long placeId){
    	
    	monitoringService.unMonitorPlace(placeId);
    	
        return ok("UnMonitored placeId "+ placeId);
    }
    

}
