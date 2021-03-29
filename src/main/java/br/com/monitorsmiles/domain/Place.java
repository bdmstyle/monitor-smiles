package br.com.monitorsmiles.domain;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(NON_NULL)
@Data
@Document(collection = "place")
public class Place {
	
	@JsonIgnore
	@Id
    private ObjectId id;
	
	private Long placeId;
	
    private String name,nameState, headerUrl, descriptionUrl, description, thumbnailUrl;
    
    private LocalDateTime lastUpdated;
    
    private List<Item> itens;
    
    private Boolean isMonitored;
    
    public Place(){
    	itens = new ArrayList<>();
    }
    
    public void addItem(Item item) {
    	itens.add(item);
    }
    
    public Place clearItens() {
    	itens = null;
    	headerUrl = null;
    	descriptionUrl = null;
    	description = null;
    	lastUpdated = null;
    	isMonitored = null;
    	nameState = null;
    	return this;
    }
    
    public void generateId() {
    	
    	if(placeId == null)
    		placeId = Long.valueOf(new Random().nextInt(999));
     }
    

}
