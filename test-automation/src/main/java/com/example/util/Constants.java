package com.example.util;

public class Constants {
    public static final String WEB_BASE_URL = "https://www.trendyol.com/giris?cb=/";

    // API Test BASE_URL
    public static final String API_BASE_URL = "http://localhost:8080";

    // Boutique Page URLs
    public static final String BASE_URL = "https://www.trendyol.com";
    public static final String API_URL = "https://public.trendyol.com/discovery-web-websfxlanding-santral/api/v1/boutiquelist?boutiqueId=0&culture=tr-TR&channelId=1";

    // API Endpoints
    public static final String API_BOOKS_ENDPOINT = "/api/books/";
    public static final String API_BOOK_BY_ID_ENDPOINT = "/api/books/%d";

    // Login Page Selectors
    public static final String USERNAME_FIELD_ID = "login-email";
    public static final String PASSWORD_FIELD_ID = "login-password-input";
    public static final String LOGIN_BUTTON_CSS = "[type='submit']";
    public static final String FACEBOOK_LOGIN_BUTTON_CSS = ".social-account-login-buttons > div:nth-of-type(1)";
    public static final String GOOGLE_LOGIN_BUTTON_CSS = ".social-account-login-buttons > div:nth-of-type(2)";
    public static final String FORGOT_PASSWORD_BUTTON_CSS = ".forgot-password span";
    public static final String SIGN_UP_BUTTON_CSS = "[aria-pressed='false']";
    public static final String ORDER_TRACKING_BUTTON_CSS = ".clickable-text";
    public static final String SHOW_PASSWORD_ICON_CSS = ".i-eye-close";
    public static final String CLOSE_PASSWORD_ICON_CSS = ".i-eye-open";
    public static final String ERROR_MESSAGE_CSS = "div#error-box-wrapper > .message";
    public static final String POPULAR_CSS = ".widget-width:nth-of-type(3) .widget-gw-widget > div:nth-of-type(1) span";
}
