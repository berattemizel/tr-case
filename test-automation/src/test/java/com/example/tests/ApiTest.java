package com.example.tests;

import com.example.util.ApiHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApiTest {

    // Validates the book details in the response with expected title and author.
    private void assertBookDetails(Response response, String expectedTitle, String expectedAuthor) {
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), expectedTitle);
        Assert.assertEquals(response.jsonPath().getString("author"), expectedAuthor);
    }

    // Validates the error message and status code in the response.
    private void assertBookError(Response response, int expectedStatusCode, String expectedErrorMessage) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
        Assert.assertTrue(response.jsonPath().getString("error").contains(expectedErrorMessage),
                "Error message is incorrect. Expected to contain: " + expectedErrorMessage);
    }

    // Creates a book using the API and validates its details.
    private int createAndValidateBook(String title, String author) {
        Response response = ApiHelper.putBook(title, author);
        assertBookDetails(response, title, author);
        return response.jsonPath().getInt("id");
    }
    
    @DataProvider(name = "invalidBookDataProvider")
    public Object[][] invalidBookDataProvider() {
        return new Object[][] {
            { "Valid Title", null, 400, "Field 'author' is required" },
            { null, "Valid Author", 400, "Field 'title' is required" },
            { "", "Valid Author", 400, "Field 'title' cannot be empty" },
            { "Valid Title", "", 400, "Field 'author' cannot be empty" }
        };
    }
    
    @Test
    public void testApiStartsWithEmptyStore() {
        Response response = ApiHelper.getAllBooks();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("$").isEmpty(), "The book list was expected to be empty at the start, but it is not.");
    }

    @Test(dataProvider = "invalidBookDataProvider")
    public void testInvalidBookData(String title, String author, int expectedStatusCode, String expectedErrorMessage) {
        Response response = ApiHelper.putBook(title, author);
        assertBookError(response, expectedStatusCode, expectedErrorMessage);
    }

    @Test
    public void testIdFieldIsReadOnly() {
        Response response = ApiHelper.putBookWithId(999, "New Book", "New Author");
        assertBookError(response, 400, "id field is read-only");
    }

    @Test
    public void testCreateAndCheckBook() {
        int bookId = createAndValidateBook("New Book", "New Author");

        Response getResponse = ApiHelper.getBookById(bookId);
        assertBookDetails(getResponse, "New Book", "New Author");
    }

    @Test
    public void testCannotCreateDuplicateBook() {
        createAndValidateBook("New Book", "New Author");

        Response response = ApiHelper.putBook("New Book", "New Author");
        assertBookError(response, 400, "Another book with similar title and author already exists");
    }

    @Test
    public void testCanCreateDuplicatedTitleBook() {
        createAndValidateBook("New Book", "New Author");

        Response response = ApiHelper.putBook("New Book", "New Author2");
        assertBookDetails(response, "New Book", "New Author2");
    }

    @Test
    public void testCanCreateDuplicatedAuthorBook() {
        createAndValidateBook("New Book", "New Author");

        Response response = ApiHelper.putBook("New Book2", "New Author");
        assertBookDetails(response, "New Book2", "New Author");
    }
}
