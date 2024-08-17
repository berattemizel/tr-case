package com.example.tests;

import com.example.util.Constants;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class ReportingTest extends BaseTest {

    @Test
    @Description("Testing the reporting functionality with Allure")
    public void testWithReport() {
        driver.get(Constants.WEB_BASE_URL);
    }
}
