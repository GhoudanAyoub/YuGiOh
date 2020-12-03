package com.example.hilt_java.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Fav")
public class Fav {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private card card;

    public Fav() {
    }

    public Fav( card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.example.hilt_java.Models.card getCard() {
        return card;
    }

    public void setCard(com.example.hilt_java.Models.card card) {
        this.card = card;
    }
}
