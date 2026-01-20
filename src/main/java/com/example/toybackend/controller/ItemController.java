package com.example.toybackend.controller;

import com.example.toybackend.dto.CreateItemRequest;
import com.example.toybackend.dto.ItemResponse;
import com.example.toybackend.service.ItemService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public ItemResponse create(@RequestBody CreateItemRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<ItemResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ItemResponse getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public ItemResponse update (@PathVariable Long id, @RequestBody CreateItemRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
