package com.tennisscheduler.model;

import jakarta.persistence.*;
@Entity
public class Match {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Tournament tournament;

    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    private String date;

    public Match() {}
    public Match(Tournament tournament, Player player1, Player player2, String date){
        this.tournament = tournament;
        this.player1 = player1;
        this.player2 = player2;
        this.date = date;
    }

    // Getters & Setters
}