package com.example.hilt_java.Models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class card {
    private int id;
    private String name;
    private String type;
    private String desc;
    private int atk;
    private int def;
    private int level;
    private String race;
    private String attribute;
    @SerializedName("card_images")
    private List<cardImage> cardImageList;
    @SerializedName("card_sets")
    private List<cardSet> cardSetList;
    @SerializedName("card_prices")
    private List<cardPrice> cardPriceList;


    public card() {
    }

    public List<cardImage> getCardImageList() {
        return cardImageList;
    }

    public void setCardImageList(List<cardImage> cardImageList) {
        this.cardImageList = cardImageList;
    }

    public List<cardSet> getCardSetList() {
        return cardSetList;
    }

    public void setCardSetList(List<cardSet> cardSetList) {
        this.cardSetList = cardSetList;
    }

    public List<cardPrice> getCardPriceList() {
        return cardPriceList;
    }

    public void setCardPriceList(List<cardPrice> cardPriceList) {
        this.cardPriceList = cardPriceList;
    }

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
