package com.mowei.summerexercise.service;

import com.mowei.summerexercise.Sight;
import com.mowei.summerexercise.repository.SightsRepository;
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
