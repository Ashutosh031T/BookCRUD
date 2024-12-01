package com.example.MyProject.controller;

import com.example.MyProject.dto.BookDto;
import com.example.MyProject.model.BookModel;
import com.example.MyProject.service.BookService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/check")
    public String runServerCheck(){
        return "Server is running on port 8080 ....";
    }
@PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody BookDto dto){
        bookService.saveBook(dto);
        return ResponseEntity.ok().body("Book Added Successfully ... ");
}
@GetMapping("/getAllBook")
    public ResponseEntity<List<BookModel>> getAllBook(){
        List<BookModel> books = bookService.getBooks();
        return ResponseEntity.ok().body(books);
}
@GetMapping("getBookById/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable ObjectId id){
        BookModel bookModel = bookService.bookById(id);
        if(bookModel !=null){
            return ResponseEntity.ok().body(bookModel);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
}
@GetMapping("getBookByName")
    public ResponseEntity<BookModel> getBookByName(@RequestParam String bookName){
        BookModel bookModel = bookService.bookByName(bookName);
        return  ResponseEntity.ok().body(bookModel);
}
@PutMapping("/updateBook/{id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable ObjectId id, @RequestBody BookDto dto){
        BookModel bookModel = bookService.updateBook(id,dto);
        return ResponseEntity.ok(bookModel);
}
@DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable ObjectId id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book Deleted Successfully");
    }
@PatchMapping("/updateBookById/{id}")
    public ResponseEntity<BookModel> updateBookById(@PathVariable ObjectId id,@RequestBody BookModel model){
        try {
            BookModel updateBook = bookService.updateById(id,model);
            return ResponseEntity.status(HttpStatus.OK).body(updateBook);
        }
        catch (RuntimeException e){
         return   ResponseEntity.notFound().build();
        }
    }
}
