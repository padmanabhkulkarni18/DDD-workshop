package com.aardling.dddinlanguage.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DroppedFractions(int amount_dropped, @JsonProperty("fraction_type") FractionType fractionType ) {

    public Price calculatePrice(){
        double rawPrice =  amount_dropped* fractionType.getPricePerKg();
        return new Price(rawPrice,Currency.EUR);
    }
}
