package com.example.study.controller.item;

import com.example.study.entity.Item;
import com.example.study.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

   @Autowired
   private ItemRepository itemRepository;

   @GetMapping("/items")
   public List<Item> getItems(){
      List<Item> items= itemRepository.findAll();
      return items;
   }
}
