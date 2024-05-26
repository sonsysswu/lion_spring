package com.example.study.service;

import com.example.study.entity.Book;
import com.example.study.model.AddBookInput;
import com.example.study.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
   private BookRepository bookRepository;
   public BookService(BookRepository bookRepository){
      this.bookRepository=bookRepository;
   }
   public long addBook(AddBookInput input){
      Book book = Book.builder()
              .name(input.getBookName())
              .price(String.valueOf(input.getBookPrice()))
              .build();
      //builder 패턴을 사용하면 name을 직관적으로 표현 가능.
      Book saved = bookRepository.save(book);
      return saved.getId();
   }
}
