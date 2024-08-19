package com.secret.summerexercise.KeelungSightsCrawler;

import com.secret.summerexercise.Sight;

public class KeelungSightsCrawlerTest {

    public static void main(String[] args) {
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        Sight[] sights = crawler.getSights("七堵區");

        for (Sight s : sights) {
            System.out.println(s);
        }
    }
}

