package com.example.study.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="book")
   public class Book {
   @Id //primary key 설정
   @GeneratedValue(strategy = GenerationType.IDENTITY) // 아이디 생성을 db에 권한 위임
   private Long id;


   @Column(name="name")
   private String name;

   @Column(name = "price")
   private String price;

}
