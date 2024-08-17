package com.example.tests;

import com.example.pages.BoutiquePage;
import com.example.util.CSVWriterUtil;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CollectBoutiqueLinksTest extends BaseTest {

    @Test
    public void collectBoutiqueLinksAndImageLoadTimes() {
        WebDriver driver = new ChromeDriver();
        BoutiquePage boutiquePage = new BoutiquePage(driver);
        List<String> links = boutiquePage.getBoutiqueLinks();

        CSVWriterUtil.saveLinksToCSV(links, "boutique_links_load_times.csv", boutiquePage);

        driver.quit();
    }
}
