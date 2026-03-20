package com.aardling.dddinlanguage.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FractionType {

    GREEN_WASTE(0.10),
    CONSTRUCTION_WASTE(0.15);

    private final double pricePerKg;

    FractionType(double pricePerKg){
        this.pricePerKg = pricePerKg;
    }

    public double getPricePerKg(){
        return pricePerKg;
    }

    @JsonCreator
    public static FractionType fromString(String value) {
        return switch (value.toLowerCase()){
            case "green waste" -> GREEN_WASTE;
            case "construction waste" -> CONSTRUCTION_WASTE;
            default -> throw new IllegalArgumentException("Unknown fraction type"+ value);
        };
    }
}
