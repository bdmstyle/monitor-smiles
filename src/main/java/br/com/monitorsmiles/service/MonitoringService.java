package br.com.monitorsmiles.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.monitorsmiles.domain.ApiSecurity;
import br.com.monitorsmiles.domain.Place;
import br.com.monitorsmiles.persistence.MonitorRepository;

@Service
public class MonitoringService {
	
	@Autowired
	private ApiSecurity apiSecurity;
	
    @Autowired
    private MonitorRepository monitorRepository;
    
    @Autowired
    private PlaceService placeService;

	
	
	public Boolean isMonitored(Long placeId) {
		return getPlacesMonitoredByCurrentUser()
				.stream()
				.map(monitoredPlace -> monitoredPlace.getPlaceId())
				.collect(toList())
				.contains(placeId);
	}
	
	public List<Long> getAllClientsForMonitoredPlace(Long placeId) {
		
		return monitorRepository.findAll()
								.stream()
								.filter(monitor -> monitor.getPlaceIds().contains(placeId))
								.map(monitor -> monitor.getSmilesId())
								.collect(toList());
		
	}
	
	public void monitorPlace(Long placeId) {
		
		placeService.verifyIfPlaceExists(placeId);
		
    	var monitor = monitorRepository.findBySmilesId(apiSecurity.getSmilesId());
    
    	monitor.monitorPlace(placeId);
    	
    	monitorRepository.save(monitor);
		
	}
	
	public void unMonitorPlace(Long placeId) {
		
		placeService.verifyIfPlaceExists(placeId);
		
    	var monitor = monitorRepository.findBySmilesId(apiSecurity.getSmilesId());
    
    	monitor.unMonitorPlace(placeId);
    	
    	monitorRepository.save(monitor);
		
	}
	
	public Boolean isMonitored(Place place) {
		return isMonitored(place.getPlaceId());
	}

	public List<Long> currentUserMonitoredPlaceIds() {
		return new ArrayList<>(monitorRepository.findBySmilesId(apiSecurity.getSmilesId()).getPlaceIds());
	}

	public List<Place> getPlacesMonitoredByCurrentUser() {
		return placeService.getAllPlaces(currentUserMonitoredPlaceIds());
	}

}
