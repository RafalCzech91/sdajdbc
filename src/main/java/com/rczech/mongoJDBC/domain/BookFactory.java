package com.rczech.mongoJDBC.domain;

import org.bson.Document;

import java.util.List;

public class BookFactory {

    public Document create(String title, String author, List <String> categories) {
        Document book = new Document()
                .append("title", title )
                .append("author", author)
                .append("categories", categories)
                ;
        return book;
    }
}
