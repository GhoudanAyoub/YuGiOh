package com.example.hilt_java.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "card")
public class card {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String type;
    private String desc;
    private int atk;
    private int def;
    private int level;
    private String race;
    private String attribute;

    /*
    @SerializedName("card_sets")
    private card_sets card_sets;
    @SerializedName("card_images")
    private card_images card_images;
    @SerializedName("card_prices")
    private card_prices card_prices;
*/
    public card() {
    }
/*
    public card_prices getCard_prices() {
        return card_prices;
    }

    public void setCard_prices(card_prices card_prices) {
        this.card_prices = card_prices;
    }

    public card_images getCard_images() {
        return card_images;
    }

    public void setCard_images(card_images card_images) {
        this.card_images = card_images;
    }

    public card_sets getCard_sets() {
        return card_sets;
    }

    public void setCard_sets(card_sets card_sets) {
        this.card_sets = card_sets;
    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
