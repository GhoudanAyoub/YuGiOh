package com.example.hilt_java.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class card_sets {
    @SerializedName("card_sets")
    private List<cardSet> cardSet = null;

    public card_sets() { }

    public List<cardSet> getCardSet() { return cardSet; }

    public void setCardSet(List<cardSet> cardSet) { this.cardSet = cardSet; }
}
