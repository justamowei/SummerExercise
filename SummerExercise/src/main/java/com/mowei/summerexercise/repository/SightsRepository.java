package com.secret.summerexercise.repository;

import com.secret.summerexercise.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SightsRepository extends MongoRepository<Sight, String> {
    List<Sight> findByZone(String zone);
    Sight findBySightNameAndZone(String sightName, String zone);
}
