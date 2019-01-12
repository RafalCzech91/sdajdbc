package com.rczech.mongoJDBC.domain;

import org.bson.Document;

import java.util.List;

import static java.time.LocalDateTime.now;

public class MembershipCardFactory {
    private static Document aMemebershipCard(String name, String lastName, List<String> books, String number) {
        return new Document()
                .append("person", new Document()
                        .append("firstName", name)
                        .append("lastName", lastName)
                )
                .append("books", books)
                .append("creationDate", now().toString())
                .append("number", number);
    }
    }

