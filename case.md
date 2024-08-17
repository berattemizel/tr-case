<h1 align="left"> Test Automation Engineer </h1>

<h3 align="left"> Chapter 1 </h3>

1. All boutique links on the home page of Trendyol and response code appearing once a request is made for these links should be recorded in a csv file.

2. The loading durations of boutique image links appearing when it is scrolled and the response codes should be recorded in a csv file.

3. We expect you to run the login cases that you will design in a data-driven manner. Here we expect you to write all the tests that, you think, should be performed in a login case.

- System should be designed to run in a way to be parallel and cross-browser.
- For the login test, one of the cases should run in a way to fail, and the screenshot of the failing moment should be reported.
- While writing the test, attention should be paid to universal software standards such as legibility, denominations, code repetition, OOP; a class structure that is available to grow structurally should be built; and design patterns should be used.
- Tests should be improved with java language, using selenium library.
- At the end of tests, a reporting screen displaying the results should be added.
- A brief read.me file on how and where the tests will run should be prepared.
- Tests should be run with selenium-grid in docker containers through compose file.

<h3 align="left"> Chapter 2 </h3>

Your friend has written an app that gives you a convenient way of storing a list of books you own. The application uses a REST API with a backend server to exchange information. Your task is to test the REST API used by the app to make sure it works correctly.

The server contains only one object:
~~~~
class Book: int id; // Read-only. String author; String title;
~~~~
The communication between backend and app is serialized into JSON format for convenience and readability. An example book serialized to JSON appears as follows:
~~~~
{ "id": 1, "author": "John Smith", "title": "Reliability of late night deployments" }
~~~~
An example response containing a list of books is as follows:
~~~~
[ {"id": 1, "author": "John Smith", "title": "SRE 101"}, {"id": 2, "author": "Jane Archer", "title": "DevOps is a lie"}, ]
~~~~
For consistency, you *cannot* add a book with the same title and author twice. The API
consists of the following endpoints:
~~~~
/api/books/
~~~~
When called with the GET method, returns the list of your books.

When called with the PUT method, inserts a new book into your list and returns the newly created book. Returns an error if any occurred.
~~~~
/api/books/<book_id>/
~~~~
When called with the GET method, returns a single book. Returns HTTP 404 Not Found if the book with the given id does not exist.

All error responses have a status code of HTTP 400 Bad Request and contain an object with a single key, error, that contains the error message. An example error message as follows:
~~~~
{ "error": "Field 'author' is required" }
~~~~

### Requirements
1. Verify that the API starts with an empty store.

- At the beginning of a test case, there should be no books stored on the server.

2. Verify that title and author are required fields.
~~~~
PUT on /api/books/ should return an error Field '<field_name>' is required
~~~~
3. Verify that title and author cannot be empty.
~~~~
PUT on /api/books/ should return an error Field '<field_name>' cannot be empty
~~~~
4. Verify that the id field is read−only.
~~~~
You shouldn't be able to send it in the PUT request to /api/books/
~~~~
5. Verify that you can create a new book via PUT.

- The book should be returned in the response.
~~~~
GET on /api/books/<book_id>/ should return the same book
~~~~
6. Verify that you cannot create a duplicate book.
~~~~
PUT on /api/books/ should return an error: Another book with similar title and author already exists
~~~~

Assessment/Tools
- The API might return an HTTP 500 Internal Server Error. This is never intended, and a test that encounters it should fail appropriately.
- Make sure your test class extends APITestCase.
- Make sure all your test cases are decorated with test.
- The testing API is reset before each of your test cases. You don't have to worry about it.
- The APITestCase.API_ROOT variable contains the API root you should use to access the API.
- Make sure at least one test detects regression in one of the requirements and breaks.
- Performance is not assessed; focus only on the correctness of the tests.

**PS:** Please include **"case is done"** in your last commit.

## Follow Us!

[Trendyol Tech Medium](https://medium.com/trendyol-tech)

[Trendyol Open Source GitHub](https://github.com/Trendyol)

[Trendyol Tech Youtube](https://www.youtube.com/channel/UCUBiayLMggBAsiYvGLzQJ5w)

[Trendyol Tech Kommunity](https://kommunity.com/@trendyol)
