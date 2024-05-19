package com.example.study.controller.book;

import com.example.study.entity.Book;
import com.example.study.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
   @Autowired //자동으로 객체를 주입할 수 있게.
   private BookRepository bookRepository;

   @GetMapping("/book")
   public List<Book> getBooks(){
      List<Book> books = bookRepository.findAll();
      return books;
   }
}
