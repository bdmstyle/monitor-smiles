package br.com.monitorsmiles.resource;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitorsmiles.service.NotifyService;

@CrossOrigin(origins = "*")
@RestController
public class NotifyResource {
	
	@Autowired
	private NotifyService notifyService;
	
	//an partner provide de updates for us
	//this increase the number of downloads de app because is gonna be usefull
	
    //call smiles apis to notify the users that have updates in your monitored places by app push notifications
    @PostMapping(value = "/notify/{placeId}")
    public ResponseEntity<List<Long>> notifyPlaceUpdate(@PathVariable("placeId") Long placeId){
    	
        return ok(notifyService.notifyPlaceUpdate(placeId));
     
    }

}
