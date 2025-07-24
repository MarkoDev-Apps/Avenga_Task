package com.bookstore.api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = System.getProperty("BASE_URL", "https://fakerestapi.azurewebsites.net");
    }
}