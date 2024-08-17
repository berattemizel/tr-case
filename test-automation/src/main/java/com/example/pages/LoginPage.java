package com.example.pages;

import com.example.util.Constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(id = Constants.USERNAME_FIELD_ID)
    private WebElement usernameField;

    @FindBy(id = Constants.PASSWORD_FIELD_ID)
    private WebElement passwordField;

    @FindBy(css = Constants.LOGIN_BUTTON_CSS)
    private WebElement loginButton;

    @FindBy(css = Constants.FACEBOOK_LOGIN_BUTTON_CSS)
    private WebElement facebookLoginButton;

    @FindBy(css = Constants.GOOGLE_LOGIN_BUTTON_CSS)
    private WebElement googleLoginButton;

    @FindBy(css = Constants.FORGOT_PASSWORD_BUTTON_CSS)
    private WebElement forgotPasswordButton;

    @FindBy(css = Constants.SIGN_UP_BUTTON_CSS)
    private WebElement signUpButton;

    @FindBy(css = Constants.ORDER_TRACKING_BUTTON_CSS)
    private WebElement orderTrackingButton;

    @FindBy(css = Constants.SHOW_PASSWORD_ICON_CSS)
    private WebElement showPasswordIcon;

    @FindBy(css = Constants.CLOSE_PASSWORD_ICON_CSS)
    private WebElement closePasswordIcon;

    @FindBy(css = Constants.ERROR_MESSAGE_CSS)
    private WebElement errorMessage;

    @FindBy(css = Constants.POPULAR_CSS)
    private WebElement popularText;

    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public LoginPage enterCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return this;
    }

    public LoginPage clickFacebookLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(facebookLoginButton));
        facebookLoginButton.click();
        return this;
    }

    public LoginPage clickGoogleLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(googleLoginButton));
        googleLoginButton.click();
        return this;
    }

    public LoginPage clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordButton));
        forgotPasswordButton.click();
        return this;
    }

    public LoginPage clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
        return this;
    }

    public LoginPage clickOrderTracking() {
        wait.until(ExpectedConditions.elementToBeClickable(orderTrackingButton));
        orderTrackingButton.click();
        return this;
    }

    public LoginPage toggleShowPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(showPasswordIcon));
        showPasswordIcon.click();
        return this;
    }

    public LoginPage toggleClosePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(closePasswordIcon));
        closePasswordIcon.click();
        return this;
    }

    public String getPasswordFieldType() {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        return passwordField.getAttribute("type");
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public String getPopularText() {
        wait.until(ExpectedConditions.visibilityOf(popularText));        
        return popularText.getText();
    }
}
