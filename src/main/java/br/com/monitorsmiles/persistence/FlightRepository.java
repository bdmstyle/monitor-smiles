package br.com.monitorsmiles.persistence;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.monitorsmiles.domain.Flight;

public interface FlightRepository extends MongoRepository<Flight, ObjectId> {

	List<Flight> findAllBySmilesId(Long id);

}