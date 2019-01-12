package com.rczech.mongoJDBC;

import com.mongodb.client.MongoCollection;
import com.rczech.mongoJDBC.domain.BookFactory;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class ShopApp {      // Ctrl+Alt+F - reafoctoring

    public static void main(String[] args) {

        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

        MongoCollection <Document> books = new MongoCollections(mongoClientConnectivity).getCollection("books");

        BookFactory bookFactory = new BookFactory();

        String title = "Clean Code";
        String author = "Robert C.Martin";
        List<String> categories = Arrays.asList("code quality", "design", "software development");


        Document book = new BookFactory().create(title,author, categories);

        books.insertOne(book);

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
