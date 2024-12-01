package com.example.MyProject.serviceImp;

import com.example.MyProject.dto.BookDto;
import com.example.MyProject.model.BookModel;
import com.example.MyProject.repsitory.BookRepository;
import com.example.MyProject.service.BookService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceInp implements BookService {
    @Autowired
    private BookRepository repo;
    @Override
    public void saveBook(BookDto dto) {
        BookModel model = new BookModel();
        model.setBookName(dto.getBookName());
        model.setAuthor(dto.getAuthor());
        model.setPrice(dto.getPrice());
        repo.save(model);
    }

    @Override
    public List<BookModel> getBooks() {
        return repo.findAll();
    }

    @Override
    public BookModel bookById(ObjectId id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public BookModel bookByName(String bookName) {
        return repo.findBybookName(bookName).orElse(null);
    }

    @Override
    public BookModel updateBook(ObjectId id, BookDto dto) {
        BookModel model = repo.findById(id).orElse(null);
        if(model !=null){
            model.setBookName(dto.getBookName());
            model.setAuthor((dto.getAuthor()));
            model.setPrice(dto.getPrice());
        }
        return repo.save(model);
    }

    @Override
    public void deleteBook(ObjectId id) {
//        BookModel model = repo.findById(id).get();
//        repo.delete(model);
        repo.deleteById(id);
    }

    @Override
    public BookModel updateById(ObjectId id, BookModel model) {
        BookModel bookModel = repo.findById(id).orElse(null);
        if(bookModel == null){
            throw new RuntimeException("Book not Found "+id);
        }
        if(model.getBookName() !=null){
            bookModel.setBookName(model.getBookName());
        }
        if(model.getAuthor() !=null){
            bookModel.setAuthor(model.getAuthor());
        }
        if(model.getPrice() >0){
            bookModel.setPrice(model.getPrice());
        }
        return repo.save(bookModel);
    }
}
