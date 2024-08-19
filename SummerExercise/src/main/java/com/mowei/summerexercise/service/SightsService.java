package com.secret.summerexercise.service;

import com.secret.summerexercise.Sight;
import com.secret.summerexercise.repository.SightsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightsService {

    private final SightsRepository sightRepository;

    public SightsService(SightsRepository sightRepository) {
        this.sightRepository = sightRepository;
    }

    public List<Sight> getSightsByZone(String zone) {
        return sightRepository.findByZone(zone);
    }
}
