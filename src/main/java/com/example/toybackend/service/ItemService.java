package com.example.toybackend.service;

import com.example.toybackend.dto.CreateItemRequest;
import com.example.toybackend.dto.ItemResponse;
import com.example.toybackend.model.Item;
import com.example.toybackend.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    public ItemResponse create(CreateItemRequest req) {
        Item item = new Item(req.getName());
        Item saved = repo.save(item);

        return toResponse(saved);
    }

    private ItemResponse toResponse(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getCreatedAt()
        );
    }
}
