package com.example.toybackend.service;

import com.example.toybackend.dto.CreateItemRequest;
import com.example.toybackend.dto.ItemResponse;
import com.example.toybackend.exception.ItemNotFoundException;
import com.example.toybackend.model.Item;
import com.example.toybackend.repository.ItemRepository;
import java.util.List;
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

    public List<ItemResponse> getAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public ItemResponse getOne(Long id) {
        Item item = repo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        return toResponse(item);
    }

    public ItemResponse update(Long id, CreateItemRequest req) {
        Item item = repo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        item.setName(req.getName());
        return toResponse(repo.save(item));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private ItemResponse toResponse(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getCreatedAt()
        );
    }
}
