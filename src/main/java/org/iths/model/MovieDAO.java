package org.iths.model;


import org.bson.Document;

import java.util.List;

public interface MovieDAO {
    void insert(String title, int year);

    List<Document> findAll();
}
