package com.bookstore.api.tests;
import com.bookstore.api.base.TestBase;
import com.bookstore.api.utils.AuthorPayloads;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import static org.hamcrest.Matchers.*;

@Listeners({AllureTestNg.class})
//@Listeners({io.qameta.allure.testng.AllureTestNg.class})
@Epic("Authors API")
@Feature("CRUD Operations on Authors")
public class AuthorTests extends TestBase {

    @Test(description = "Retrieve a list of all authors.")
    @Story("Retrieve Authors")
    public void testGetAllAuthors() {
        RestAssured.given()
                .when().get("/api/v1/Authors")
                .then().statusCode(200).body("size()", greaterThan(0));
    }

    @Test(description = "Add a new author to the system.")
    @Story("Add New Author")
    public void testCreateAuthor() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(AuthorPayloads.createValidAuthor().toString())
                .when().post("/api/v1/Authors")
                .then().statusCode(200).body("firstName", equalTo("John"));
    }

    @Test(description = "Retrieve details of a specific author by their ID.")
    @Story("Get Author by ID")
    public void testGetInvalidAuthor() {
        RestAssured.given()
                .when().get("/api/v1/Authors/99999")
                .then().statusCode(404);
    }

    @Test(description = "Update an existing author’s details.")
    @Story("Update Author Details")
    public void testUpdateAuthor() {
        JSONObject payload = AuthorPayloads.createValidAuthor();
        payload.put("firstName", "Jane");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload.toString())
                .when().put("/api/v1/Authors/500")
                .then().statusCode(200).body("firstName", equalTo("Jane"));
    }

    @Test(description = "Delete an author by their ID.")
    @Story("Delete Author by ID")
    public void testDeleteAuthor() {
        RestAssured.given()
                .when().delete("/api/v1/Authors/500")
                .then().statusCode(200);
    }

}
