package br.com.monitorsmiles.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.monitorsmiles.domain.ApiSecurity;
import br.com.monitorsmiles.domain.Flight;
import br.com.monitorsmiles.persistence.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private ApiSecurity apiSecurity;
	
	@Autowired
	private MonitoringService monitoringService;
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getFlightsFromCurrentUser() {
		
		var userFlights = flightRepository.findAllBySmilesId(apiSecurity.getSmilesId());
		
		return userFlights.stream()
					.map(flight -> {
							flight.setMonitored(monitoringService.isMonitored(flight.getDestinationPlaceId()));
						return flight;
					}).collect(toList());
		
	}
	
}
