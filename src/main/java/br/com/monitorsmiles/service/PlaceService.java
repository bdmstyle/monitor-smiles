package br.com.monitorsmiles.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.monitorsmiles.domain.Place;
import br.com.monitorsmiles.exception.PlaceAlreadyExistisException;
import br.com.monitorsmiles.exception.PlaceNotExistException;
import br.com.monitorsmiles.persistence.PlaceRepository;

@Service
public class PlaceService {
	
    @Autowired
    private PlaceRepository placeRepository;
    
    @Autowired
    private MonitoringService monitoringService;
    
    public Place getPlaceDetail(Long id) {
    	
    	var place = getPlace(id);
    	
    	place.setIsMonitored(monitoringService.isMonitored(place));
    	
    	return place;
    	
    }
    
    public Place newPlace(Place place) {
    	
    	verifyIfPlaceIsNew(place);
    	
    	placeRepository.save(place);
       
    	return place;
    	
    }
    
    public Place updatePlace(Place place) {
    	
    	placeRepository.delete(getPlace(place));
    	
        placeRepository.save(place);
       
    	return place;
    	
    }

	public void delete(Long id) {
		placeRepository.delete(getPlace(id));
	}
	
	public List<Place> getAllPlaces() {
		
		return placeRepository.findAll()
							  .stream()
							  .map(place -> place.clearItens())
							  .collect(toList());
	}
	
	public void verifyIfPlaceExists(Long placeId) {
		getPlace(placeId);
	}

	private Place getPlace(Long placeId) {
		
		var place = placeRepository.findByPlaceId(placeId);

		if (place == null)
			throw new PlaceNotExistException();
		
		return place;
	}
	
	private Place getPlace(Place place) {
		return getPlace(place.getPlaceId());
	}
	
	private void verifyIfPlaceIsNew(Place requestPlace) {
		
		var place = placeRepository.findByPlaceId(requestPlace.getPlaceId());

		if (place != null)
			throw new PlaceAlreadyExistisException();
		
		requestPlace.generateId();
		
	}

	public List<Place> getAllPlaces(List<Long> monitoredPlaces) {
		return placeRepository.findByPlaceIdIn(monitoredPlaces).stream()
				  											   .map(places -> places.clearItens())
				  											   .collect(toList());
	}
	
	

}
