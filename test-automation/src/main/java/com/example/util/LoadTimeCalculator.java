package com.example.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoadTimeCalculator {

    private WebDriver driver;

    public LoadTimeCalculator(WebDriver driver) {
        this.driver = driver;
    }

    // Measures the time taken for an image to load on a webpage.
    public long calculateLoadTime(String imageUrl) {
        long startTime = System.currentTimeMillis();

        driver.get(imageUrl);

        WebElement imageElement = driver.findElement(By.tagName("img"));

        while (!imageElement.isDisplayed()) {
        }

        return System.currentTimeMillis() - startTime;
    }
}
