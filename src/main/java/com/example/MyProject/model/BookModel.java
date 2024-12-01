package com.example.MyProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book_entries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {
    @Id
    private ObjectId id;

    private String bookName;
    private String author;
    private int price;

}
