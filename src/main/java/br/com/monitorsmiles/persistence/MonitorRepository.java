package br.com.monitorsmiles.persistence;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.monitorsmiles.domain.Monitor;

public interface MonitorRepository extends MongoRepository<Monitor, ObjectId> {

	Monitor findBySmilesId(Long smilesId);
}