package com.example.hilt_java.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class card_prices {

    @SerializedName("card_prices")
    private List<cardPrice> cardPrices = null;

    public card_prices() {
    }

    public List<cardPrice> getCardPrices() {
        return cardPrices;
    }

    public void setCardPrices(List<cardPrice> cardPrices) {
        this.cardPrices = cardPrices;
    }
}
