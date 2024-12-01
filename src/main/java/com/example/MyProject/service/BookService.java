package com.example.MyProject.service;

import com.example.MyProject.dto.BookDto;
import com.example.MyProject.model.BookModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface BookService {
    void saveBook(BookDto dto);

    List<BookModel> getBooks();

    BookModel bookById(ObjectId id);

    BookModel bookByName(String bookName);

    BookModel updateBook(ObjectId id, BookDto dto);

    void deleteBook(ObjectId id);

    BookModel updateById(ObjectId id, BookModel model);
}
