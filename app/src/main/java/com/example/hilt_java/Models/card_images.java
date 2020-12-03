package com.example.hilt_java.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class card_images {

    @SerializedName("card_images")
    private List<cardImage> cardImageList = null;

    public card_images() { }

    public List<cardImage> getCardImageList() {
        return cardImageList;
    }

    public void setCardImageList(List<cardImage> cardImageList) {
        this.cardImageList = cardImageList;
    }
}
