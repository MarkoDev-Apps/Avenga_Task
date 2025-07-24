package com.bookstore.api.utils;
import org.json.JSONObject;

public class AuthorPayloads {

    public static JSONObject createValidAuthor() {
        JSONObject author = new JSONObject();
        author.put("id", 500);
        author.put("idBook", 999);  // Should match an existing or test-created book ID
        author.put("firstName", "John");
        author.put("lastName", "Doe");
        return author;
    }

}
