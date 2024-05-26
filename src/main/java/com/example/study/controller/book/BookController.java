package com.example.study.controller.book;

import com.example.study.entity.Book;
import com.example.study.model.AddBookInput;
import com.example.study.repository.BookRepository;
import com.example.study.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
   //@Autowired //자동으로 객체를 주입할 수 있게. -> 요즘 사용을 잘 안 함
   private BookRepository bookRepository;
   private BookService bookService;
   public BookController(BookService bookService, BookRepository bookRepository){
      this.bookService = bookService;
      this.bookRepository= bookRepository;
   }

   @GetMapping("/book")
   public List<Book> getBooks(){
      List<Book> books = bookRepository.findAll();
      return books;
   }

   @PostMapping("/book")
   public long addBook(@RequestBody @Valid AddBookInput input){ //@Valid: 요청을 보내면 validation 수행.
      long id = bookService.addBook(input);
      return id;
   }
}
