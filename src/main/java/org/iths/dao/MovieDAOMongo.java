package org.iths.dao;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.iths.model.MovieDAO;

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
        return collection.find().into(new ArrayList<>());
    }
}
