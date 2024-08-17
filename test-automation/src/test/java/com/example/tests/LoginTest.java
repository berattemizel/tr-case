package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"berattemizel91@gmail.com", "ASDqwe123.", null},
            {"berattemizel91@gmail.com", "invalidPassword", "E-posta adresiniz ve/veya şifreniz hatalı."},
            {"validUser", "", "Lütfen geçerli bir e-posta adresi giriniz."},
            {"", "validPassword", "Lütfen geçerli bir e-posta adresi giriniz."},
            {"", "", "Lütfen geçerli bir e-posta adresi giriniz."},
            {"<script>alert(1)</script>", "password", "Lütfen geçerli bir e-posta adresi giriniz."},
            {"!'^!+'!'^!'+!'^!'^!'!'^!'^+@", "+!'+!'^!'^!'^^%+%^+&^+%=?=)%", "Lütfen geçerli bir e-posta adresi giriniz."}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedError) {
        loginPage.enterCredentials(username, password).clickLogin();
        
        if (expectedError == null) {
            Assert.assertTrue(loginPage.getPopularText().contains("Popüler Ürünler"), 
                  "button text did not match the expected value.");
            
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains(expectedError), 
                               "Expected error: " + expectedError + ", Actual: " + loginPage.getErrorMessage());
        }
    }

    @Test
    public void testFacebookLogin() {
        loginPage.clickFacebookLogin();
        Assert.assertTrue(driver.getTitle().contains("Facebook'a Giriş Yap"));
    }

    @Test
    public void testGoogleLogin() {
        loginPage.clickGoogleLogin();
        Assert.assertTrue(driver.getTitle().contains("Oturum açın - Google Hesapları"));
    }

    @Test
    public void testForgotPassword() {
        loginPage.clickForgotPassword();
        Assert.assertTrue(driver.getPageSource().contains("Şifre Yenileme"));
    }

    @Test
    public void testSignUpButton() {
        loginPage.clickSignUp();
        Assert.assertTrue(driver.getPageSource().contains("Cinsiyet (Opsiyonel)"));
    }

    @Test
    public void testOrderTracking() {
        loginPage.clickOrderTracking();
        Assert.assertTrue(driver.getTitle().contains("Yardım | Trendyol"));
    }

    @Test
    public void testShowPasswordIcon() {
        loginPage.enterCredentials("", "dummyPassword")
                 .toggleShowPassword();
        Assert.assertEquals(loginPage.getPasswordFieldType(), "text");
        loginPage.toggleClosePassword();
        Assert.assertEquals(loginPage.getPasswordFieldType(), "password");
    }
}
