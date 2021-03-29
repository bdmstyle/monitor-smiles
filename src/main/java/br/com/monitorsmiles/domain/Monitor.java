package br.com.monitorsmiles.domain;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(NON_NULL)
@Data
@Document(collection = "monitor")
public class Monitor {
	
	@JsonIgnore
	@Id
    private ObjectId id;
	
	private Long smilesId;
	
	private Set<Long> placeIds;
	
	public boolean isPlaceMonitored(Long placeId) {
		
		return getPlaceIds().contains(placeId);
	}
	
	public void monitorPlace(Long placeId) {
		
		if(placeIds == null)
			placeIds = new HashSet<>();
		
		getPlaceIds().add(placeId);
	}
	
	public void unMonitorPlace(Long placeId) {
		
		placeIds = getPlaceIds().stream()
					       .filter(monitoredPlaceIds -> monitoredPlaceIds != placeId)
					       .collect(toSet());
	}
	
	public static Monitor create(Long smilesId) {
		var monitor = new Monitor();
		monitor.setSmilesId(smilesId);
		monitor.setPlaceIds(new HashSet<>());
		return monitor;
	}

}
