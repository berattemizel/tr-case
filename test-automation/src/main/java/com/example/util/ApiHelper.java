package com.example.util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ApiHelper {

    // Get all books from the API
    public static Response getAllBooks() {
        return RestAssured.get(Constants.API_BASE_URL + Constants.API_BOOKS_ENDPOINT);
    }

    // Get a book by its ID
    public static Response getBookById(int bookId) {
        String endpoint = String.format(Constants.API_BOOK_BY_ID_ENDPOINT, bookId);
        return RestAssured.get(Constants.API_BASE_URL + endpoint);
    }

    // Add or update a book using a PUT request with title and/or author
    public static Response putBook(String title, String author) {
        ObjectNode requestBody = createRequestBody(null, title, author);
        return putRequest(requestBody);
    }

    // Add a new book with an ID using a PUT request
    public static Response putBookWithId(int id, String title, String author) {
        ObjectNode requestBody = createRequestBody(id, title, author);
        return putRequest(requestBody);
    }

    // Helper method to create request body
    private static ObjectNode createRequestBody(Integer id, String title, String author) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode requestBody = mapper.createObjectNode();
    
        if (id != null) {
                requestBody.put("id", id);
        }
        if (title != null) {
                requestBody.put("title", title);
        }
        if (author != null) {
                requestBody.put("author", author);
        }
    
        return requestBody;
    }

    // Common method for making a PUT request to add or update a book
    private static Response putRequest(ObjectNode requestBody) {
        return RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody.toString())
                .put(Constants.API_BASE_URL + Constants.API_BOOKS_ENDPOINT);
    }
}
