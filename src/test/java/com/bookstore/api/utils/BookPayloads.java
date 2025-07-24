package com.bookstore.api.utils;

import org.json.JSONObject;

public class BookPayloads {
    public static JSONObject createValidBook() {
        JSONObject book = new JSONObject();
        book.put("id", 999);
        book.put("title", "Test Book");
        book.put("description", "Sample Description");
        book.put("pageCount", 200);
        book.put("excerpt", "Intro...");
        book.put("publishDate", "2023-07-23T00:00:00Z");
        return book;
    }
}