package org.iths;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.iths.model.MovieDAO;
import org.iths.model.MovieDAOMongo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "mongodb+srv://anwareducation:apple3ds@ithsdb.fvicsnk.mongodb.net/?appName=ithsDB";
        try (MongoClient mongoClient = MongoClients.create(url);) {
            MongoDatabase database = mongoClient.getDatabase("ithsDB");
            MongoCollection<Document> collection = database.getCollection("Movies");
            MovieDAO movieDAO = new MovieDAOMongo(collection);

            //movieDAO.insert("Star Wars", 1999);
            //movieDAO.insert("Cars", 2006);
            //movieDAO.insert("Ford v Ferrari", 2019);

            List<Document> movies = movieDAO.findAll();

            for (Document movie : movies) {
                System.out.println(movie);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}