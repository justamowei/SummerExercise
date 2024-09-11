package com.mowei.summerexercise.applicationRunner;

import com.mowei.summerexercise.KeelungSightsCrawler.KeelungSightsCrawler;
import com.mowei.summerexercise.Sight;
import com.mowei.summerexercise.repository.SightsRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements ApplicationRunner {

    private final SightsRepository sightsRepository;
    private final KeelungSightsCrawler keelungSightsCrawler;

    public DBInitializer(SightsRepository sightsRepository, KeelungSightsCrawler keelungSightsCrawler) {
        this.sightsRepository = sightsRepository;
        this.keelungSightsCrawler = keelungSightsCrawler;
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] zones = {"中山", "信義", "仁愛", "中正", "安樂", "七堵", "暖暖"};
        for (String zone : zones) {
            Sight[] sights = keelungSightsCrawler.getSights(zone + "區");
            for (Sight sight : sights) {
                Sight existingSight = sightsRepository.findBySightNameAndZone(sight.getSightName(), sight.getZone());

                if (existingSight != null) {
                    existingSight.setCategory(sight.getCategory());
                    existingSight.setPhotoURL(sight.getPhotoURL());
                    existingSight.setDescription(sight.getDescription());
                    existingSight.setAddress(sight.getAddress());
                    sightsRepository.save(existingSight);
                } else {
                    sightsRepository.save(sight);
                }
            }
        }
        System.out.println("Data saved in MongoDB.");
    }
}

