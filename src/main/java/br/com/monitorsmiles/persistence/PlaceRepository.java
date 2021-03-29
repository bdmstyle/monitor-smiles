package br.com.monitorsmiles.persistence;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.monitorsmiles.domain.Place;

public interface PlaceRepository extends MongoRepository<Place, ObjectId> {

	Place findByPlaceId(Long id);

	List<Place> findByPlaceIdIn(List<Long> monitoredPlaces);
}