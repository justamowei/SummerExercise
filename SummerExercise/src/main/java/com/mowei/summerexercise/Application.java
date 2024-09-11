package com.mowei.summerexercise;

import com.mowei.summerexercise.KeelungSightsCrawler.KeelungSightsCrawler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public KeelungSightsCrawler keelungSightsCrawler() {
        return new KeelungSightsCrawler();
    }
}