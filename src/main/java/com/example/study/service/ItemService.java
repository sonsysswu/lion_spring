package com.example.study.service;

import com.example.study.entity.Item;
import com.example.study.model.AddBookInput;
import com.example.study.model.AddItemInput;
import com.example.study.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
   private ItemRepository itemRepository;
   public ItemService(ItemRepository itemRepository){
      this.itemRepository=itemRepository;
   }
   public long addItem(AddItemInput input){
      Item item = Item.builder()
              .name(input.getName())
              .description(input.getDescription())
              .startingPrice(input.getStartingPrice())
              .build();
      Item saved = itemRepository.save(item);
      return saved.getId();
   }
   public void updateItem(long id, AddItemInput input){
      Item item= itemRepository.findById(id).orElseThrow(()-> new RuntimeException("해당 아이템이 없습니다."));

//      if (Long.parseLong(item.getStartingPrice())>=Long.parseLong(input.getStartingPrice())) {
//         throw new RuntimeException("가격을 수정 할 때 는 등록된 가격보다 큰 값을 입력 했을 때 수정이 가능합니다.");
//      }
      if (item.getStartingPrice() >= input.getStartingPrice()) {
         throw new RuntimeException("가격을 수정 할 때는 등록된 가격보다 큰 값을 입력했을 때 수정이 가능합니다.");
      }
      if (!item.getName().equals(input.getName())) {
         throw new RuntimeException("이름은 변경할 수 없습니다.");
      }

      item.setDescription(input.getDescription());
      item.setStartingPrice(input.getStartingPrice());
      itemRepository.save(item);

   }
}
