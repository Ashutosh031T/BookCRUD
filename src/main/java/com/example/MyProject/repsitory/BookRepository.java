package com.example.MyProject.repsitory;

import com.example.MyProject.model.BookModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<BookModel, ObjectId> {
    Optional<BookModel> findBybookName(String bookName);
}
