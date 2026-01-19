package com.example.toybackend.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;
    private Instant createdAt;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {return name;}
    public Instant getCreatedAt() {return createdAt;}

    public void setName(String name) {this.name = name;}
}
