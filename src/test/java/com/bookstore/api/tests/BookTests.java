package com.bookstore.api.tests;

import com.bookstore.api.base.TestBase;
import com.bookstore.api.utils.BookPayloads;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import static org.hamcrest.Matchers.*;
//@Listeners({AllureTestNg.class})
@Epic("Books API")
@Feature("CRUD Operations on Books")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BookTests extends TestBase {

    @Test(description = "Retrieve a list of all books.")
    @Story("Retrieve Books")
    @Severity(SeverityLevel.NORMAL)
    public void testGetAllBooks() {
        RestAssured.given()
                .when().get("/api/v1/Books")
                .then().statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test(description = "Add a new book to the system.")
    @Story("Add New Book")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateBook() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(BookPayloads.createValidBook().toString())
                .when().post("/api/v1/Books")
                .then().statusCode(200)
                .body("title", equalTo("Test Book"));
    }

    @Test(description = "Retrieve details of a specific book by its ID.")
    @Story("Retrieve Book by its ID")
    @Severity(SeverityLevel.MINOR)
    public void testGetInvalidBook() {
        RestAssured.given()
                .when().get("/api/v1/Books/999999")
                .then().statusCode(404);
    }

    @Test(description = "Update an existing book by its ID.")
    @Story("Update Book")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdateBook() {
        JSONObject payload = BookPayloads.createValidBook();
        payload.put("title", "Updated Title");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload.toString())
                .when().put("/api/v1/Books/999")
                .then().statusCode(200)
                .body("title", equalTo("Updated Title"));
    }

    // test test

    @Test(description = "Delete a book by its ID.")
    @Story("Delete Book")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteBook() {
        RestAssured.given()
                .when().delete("/api/v1/Books/999")
                .then().statusCode(200);
    }
}
