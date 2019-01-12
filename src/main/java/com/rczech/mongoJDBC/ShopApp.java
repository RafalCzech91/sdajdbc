package com.rczech.mongoJDBC;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.rczech.mongoJDBC.domain.BookFactory;
import com.rczech.mongoJDBC.domain.MembershipCardFactory;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.now;

public class ShopApp {

    public static void main(String[] args) {

        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

        MongoCollections collections = new MongoCollections(mongoClientConnectivity);

        MongoCollection <Document> books = new MongoCollections(mongoClientConnectivity).getCollection("books");

        BookFactory bookFactory = new BookFactory();

        books.insertMany(Arrays.asList(
                bookFactory.create(

                        "Zbrodnia i Kara",
                        "Fiodor Dostojewski",
                        Arrays.asList("code quality", "design")
                ),
                bookFactory.create(
                        "Junit",
                        "Ktoś mądry",
                        Arrays.asList("code quality", "sofware development")
                ),
                bookFactory.create(
                        "Kubuś Pucahter",
                        "Christoper XXX",
                        Arrays.asList("software develop")
                )
        ));


        for (Document existingBook : books.find()) {
            System.out.println(existingBook);
        }

//        collections.createCollection("membershipCard");


        MongoCollection <Document> membershipCard = collections.getCollection("membershipCard");


        MembershipCardFactory aMemebershipCard = new MembershipCardFactory();

        membershipCard.insertMany(Arrays.asList(
                aMemebershipCard(
                        "rafal", "podsawwa", Arrays.asList("id1", "id2", "id3", "id4"), "13"),
                aMemebershipCard(
                        "adsfadsf", "asdfasdfasd", Arrays.asList("id1", "id3", "id4"), "2")
                        .append("vip", true),
                aMemebershipCard(
                        "asdfasdf", "asdf", Arrays.asList("id2", "id3", "id4"), "3")
                        .append("payment", 69.13)
                        .append("vip", true),
                aMemebershipCard(
                        "asdfas", "fghjf", Arrays.asList(), "123")
                        .append("payment", 691.3)
                        .append("vip", false),
                aMemebershipCard(
                        "May", "Parker", Arrays.asList("id1", "id2", "id3"), "2"),
                aMemebershipCard(
                        "Ben", "Parker", Arrays.asList("id3", "id4"), "98"),
                aMemebershipCard(
                        "Peter", "Parker", Arrays.asList("id1", "id2"), "1322"),
                aMemebershipCard(
                        "Mary Jane", "Watson", Arrays.asList("id1", "id3", "id4"), "767"),
                aMemebershipCard(
                        "Gwen", "Stacy", Arrays.asList("id1", "id2"), "79")
                        .append("payment", 1000)
                        .append("vip", true)
        ));

        for (Document existingBook : membershipCard.find()) {
            System.out.println(existingBook);
        }

//
        Bson criteria = Filters.in("vip", true);


        FindIterable<Document> documents = membershipCard
                .find(criteria)
                .sort(Sorts.orderBy(
                        Sorts.ascending("author"),
                        Sorts.ascending("title"))
                );

        int counter = 0;
        for (Document document : documents) {
            System.out.println(document);
            counter++;
        }
        System.out.println(counter);

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");



        for (Document document : books.find(criteria)) {
            System.out.println(document);
        }
            System.out.println("----------");
        System.out.println("**************");

//        Bson criteria = Filters.in("vip", Arrays.asList(true));
//
//        FindIterable <Document> documents = books
//                .find(criteria)
//                .sort(Sorts.orderBy(
//                        Sorts.ascending("author"))
//                );

//        for (Document document : documents) {
//            System.out.println(document);
//        }

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");

        for (Document existingBook : books.find()) {
            System.out.println(existingBook);
        }

        mongoClientConnectivity.close();
    }





















    private static Document aMemebershipCard(String name, String lastName, List <String> books, String number) {
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


