package com.secret.summerexercise.hw2.controller;

import com.secret.summerexercise.hw1.KeelungSightsCrawler;
import com.secret.summerexercise.hw1.Sight;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/SightAPI")
public class SightsController {

    private final KeelungSightsCrawler keelungSightsCrawler;

    public SightsController(KeelungSightsCrawler keelungSightsCrawler) {
        this.keelungSightsCrawler = keelungSightsCrawler;
    }

    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping
    public ResponseEntity<Sight[]> getSights(@RequestParam(value = "zone") String zone) {
        Sight[] sights = keelungSightsCrawler.getSights(zone + "區");
        return sights.length == 0
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(sights);
    }
}
