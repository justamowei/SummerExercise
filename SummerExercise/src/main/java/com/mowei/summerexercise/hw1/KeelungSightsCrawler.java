package com.secret.summerexercise.hw1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeelungSightsCrawler {

    private static final int CONNECTION_TIMEOUT = 50000;

    public Sight[] getSights(String targetZone) {
        List<Sight> sightList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").timeout(CONNECTION_TIMEOUT).get();
            // System.out.println(doc.html());

            Elements zones = doc.select("div#guide-point h4");
            // System.out.println(districts);

            for (Element zone : zones) {
                if (zone.text().equals(targetZone)) {
                    Element sightElement = zone.nextElementSibling();
                    // System.out.println(sightElement);

                    if (sightElement != null && sightElement.tagName().equals("ul")) {
                        Elements sightLinks = sightElement.select("li a");
                        // System.out.println(sightLinks);

                        for (Element link : sightLinks) {
                            String href = link.attr("href");

                            String sightUrl = "https://www.travelking.com.tw" + href;
                            Document sightDoc = Jsoup.connect(sightUrl).timeout(CONNECTION_TIMEOUT).get();

                            String sightZone = zone.text();
                            String sightName = sightDoc.select("meta[itemprop=name]").attr("content");
                            String category = sightDoc.select("span[property=rdfs:label]").text();
                            String photoURL = sightDoc.select("meta[itemprop=image]").attr("content");
                            String description = sightDoc.select("meta[itemprop=description]").attr("content");
                            String address = sightDoc.select("meta[itemprop=address]").attr("content");

                            Sight sight = new Sight();
                            sight.setSightName(sightName);
                            sight.setZone(sightZone);
                            sight.setCategory(category.isEmpty() ? "查無類別" : category);
                            sight.setPhotoURL(photoURL.isEmpty() ? "查無圖片" : photoURL);
                            sight.setDescription(description.isEmpty() ? "查無介紹" : description);
                            sight.setAddress(address.isEmpty() ? "查無地址" : address);
                            sightList.add(sight);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sightList.toArray(new Sight[0]);
    }
}
