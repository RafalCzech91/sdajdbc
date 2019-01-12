package com.rczech.mongoJDBC;

import com.mongodb.client.MongoCollection;
import com.rczech.mongoJDBC.domain.BookFactory;
import org.bson.Document;

import java.util.Arrays;

public class ShopApp {      // Ctrl+Alt+F - reafoctoring

    public static void main(String[] args) {

        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

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



        //Document book = new BookFactory().create(title,author, categories);

       // books.insertOne(book);

        for( Document existingBook : books.find()) {
            System.out.println(existingBook);
        }






//        MongoClient mongoClient = mongoClientConnectivity.getMongoClient();
//        MongoDatabase library = mongoClient.getDatabase("library");
//        MongoCollection <Document> books = library.getCollection("books");


//        library.createCollection("books");
//
//        for (String name : library.listCollectionNames()) {
//            System.out.println(name);
//        }




        mongoClientConnectivity.close();


    }
}
