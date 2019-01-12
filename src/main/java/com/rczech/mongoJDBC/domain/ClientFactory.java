package com.rczech.mongoJDBC.domain;

import org.bson.Document;

import java.util.List;

public class ClientFactory {
    public Document create(String firstName, String secondName, List<String> books, String numer) {
        return new Document()
                .append("firstName", firstName)
                .append("secondName", secondName)
                .append("books", books)
                .append("numer", numer)
                ;
    }

}
