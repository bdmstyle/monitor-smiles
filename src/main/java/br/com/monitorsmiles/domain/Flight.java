package br.com.monitorsmiles.domain;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(NON_NULL)
@Data
@Document(collection = "flight")
public class Flight {
	
	@JsonIgnore
	@Id
    private ObjectId id;
	
	private String locatorCode;
	
	private Long smilesId;
	
	private boolean monitored;
	
	private Long destinationPlaceId;
	
	private String originCode;
	
	private String originName;
	
	private String destinyCode;
	
	private String destinyName;
	
	private String duration;
	
	private LocalDateTime departDateTime;
	
	private LocalDateTime arriveDateTime;
	

}
