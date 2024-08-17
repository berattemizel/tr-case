package com.example.tests;

import com.example.factory.DriverFactory;
import com.example.pages.LoginPage;
import com.example.util.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(Constants.WEB_BASE_URL);
        
        // Initialize the LoginPage instance
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Taking screenshot on failure")
    private void takeScreenshot(String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Path destinationPath = Paths.get("screenshots", testName + ".png");
            Files.createDirectories(destinationPath.getParent());
            Files.copy(screenshot.toPath(), destinationPath);
            System.out.println("Screenshot saved at: " + destinationPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
