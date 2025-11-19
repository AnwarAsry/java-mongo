package org.iths.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MovieDAOMongo implements MovieDAO {
    private final MongoCollection<Document> collection;

    public MovieDAOMongo(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    @Override
    public void insert(String title, int year) {
        collection.insertOne(new Document("title", title).append("year", year));
    }

    @Override
    public List<Document> findAll() {
        FindIterable<Document> movies = collection.find();
        List<Document> moviesList = new ArrayList<>();
        for (Document movie : movies) {
            moviesList.add(movie);
        }
        return moviesList;
    }
}
