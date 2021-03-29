package br.com.monitorsmiles.resource;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitorsmiles.domain.Place;
import br.com.monitorsmiles.service.PlaceService;

@CrossOrigin(origins = "*")
@RestController
public class PlaceResource {
	
	@Autowired
	private PlaceService placeService;
    
    @GetMapping(value = "/place", produces = "application/json")
    public ResponseEntity<List<Place>> allplaces(){
    	
        return ok(placeService.getAllPlaces());
    }
    
    @GetMapping(value = "/place/{placeId}", produces = "application/json")
    public ResponseEntity<Place> getPlaceDetail(@PathVariable("placeId") Long placeId){
    	
        return ok(placeService.getPlaceDetail(placeId));
    }
	
    @PostMapping(value = "/place",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Place> newPlace(@RequestBody Place place){
    	
        return ok(placeService.newPlace(place));
    }
    
    @PutMapping(value = "/place",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Place> updatePlace(@RequestBody Place place){
    	
    	//201
        return ok(placeService.updatePlace(place));
    }
    
    @DeleteMapping(value = "/place/{placeId}")
    public ResponseEntity<String> deletePlace(@PathVariable("placeId") Long placeId){
    	
    	placeService.delete(placeId);
    	
        return ok("placeId "+ placeId +" deleted");
    }

}
