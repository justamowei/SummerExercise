package com.mowei.summerexercise.controller;

import com.mowei.summerexercise.KeelungSightsCrawler.KeelungSightsCrawler;
import com.mowei.summerexercise.Sight;

import com.mowei.summerexercise.service.SightsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/SightAPI")
public class SightsController {

    // private final KeelungSightsCrawler keelungSightsCrawler;
    private final SightsService sightsService;

    public SightsController(KeelungSightsCrawler keelungSightsCrawler, SightsService sightsService) {
        // this.keelungSightsCrawler = keelungSightsCrawler;
        this.sightsService = sightsService;
    }

    /*
    @GetMapping
    public ResponseEntity<Sight[]> getSights(@RequestParam(value = "zone") String zone) {
        Sight[] sights = keelungSightsCrawler.getSights(zone + "區");
        return sights.length == 0
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(sights);
    }
    */

    @GetMapping
    public ResponseEntity<List<Sight>> getSights(@RequestParam(value = "zone") String zone) {
        List<Sight> sights = sightsService.getSightsByZone(zone + "區");
        return sights.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(sights);
    }
}
