package com.example.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.example.util.Constants;
import com.example.util.LoadTimeCalculator;

public class BoutiquePage {

    private LoadTimeCalculator loadTimeCalculator;

    public BoutiquePage(WebDriver driver) {
        this.loadTimeCalculator = new LoadTimeCalculator(driver);
    }

    public List<String> getBoutiqueLinks() {
        List<String> links = new ArrayList<>();

        Response response = RestAssured.get(Constants.API_URL);
        List<Map<String, String>> boutiques = response.jsonPath().getList("result");

        for (Map<String, String> boutique : boutiques) {
            String urlPath = boutique.get("urlPath");
            String fullLink = Constants.BASE_URL + urlPath;
            links.add(fullLink);
        }

        return links;
    }

    public int getLinkStatusCode(String link) {
        Response response = RestAssured.get(link);
        return response.getStatusCode();
    }

    public long getImageLoadTime(String link) {
        return loadTimeCalculator.calculateLoadTime(link);
    }
}
