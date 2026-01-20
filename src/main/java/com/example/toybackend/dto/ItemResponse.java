package com.example.toybackend.dto;

import java.time.Instant;

public class ItemResponse {
    private final Long id;
    private final String name;
    private final Instant createdAt;

    public ItemResponse(Long id, String name, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public Instant getCreatedAt() {return createdAt;}
}
