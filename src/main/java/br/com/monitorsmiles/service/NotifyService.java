package br.com.monitorsmiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.monitorsmiles.integration.SmilesApiClient;

@Service
public class NotifyService {

	@Autowired
	private MonitoringService monitoringService;
	
	@Autowired
	private SmilesApiClient smilesApiClient;
	
	@Autowired
	private PlaceService slaceService;
	
	public List<Long> notifyPlaceUpdate(Long placeId) {
		
		slaceService.verifyIfPlaceExists(placeId);
		
		var clientsToBeNotified = monitoringService.getAllClientsForMonitoredPlace(placeId);
		
		clientsToBeNotified.stream()
						   .forEach(smilesId -> smilesApiClient.pushNoticationSmiles(smilesId,placeId));

		return clientsToBeNotified;
	}

}
