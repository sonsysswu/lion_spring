package com.example.study.controller.item;

import com.example.study.entity.Item;
import com.example.study.model.AddItemInput;
import com.example.study.repository.ItemRepository;
import com.example.study.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

   private ItemRepository itemRepository;
   private ItemService itemService;

   public ItemController(ItemService itemService, ItemRepository itemRepository){
      this.itemService=itemService;
      this.itemRepository=itemRepository;
   }

   @GetMapping("/items")
   public List<Item> getItems(){
      List<Item> items= itemRepository.findAll();
      return items;
   }

   @PostMapping("/items")
   public long addItem(@RequestBody @Valid AddItemInput input){
      long id = itemService.addItem(input);
      return id;
   }
}
