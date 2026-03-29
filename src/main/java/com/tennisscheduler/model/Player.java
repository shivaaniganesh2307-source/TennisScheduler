package com.tennisscheduler.model;

import jakarta.persistence.*;
@Entity
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Player() {}
    public Player(String name) { this.name = name; }

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}