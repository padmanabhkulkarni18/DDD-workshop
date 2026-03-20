package com.aardling.dddinlanguage.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroppedFractionsTests {

    @Test
    void calculatePriceForGreenWaste() {
        DroppedFractions df =
                new DroppedFractions(10, FractionType.GREEN_WASTE);

        Price price = df.calculatePrice();

        assertEquals(new Price(1.0, Currency.EUR), price);
    }

    @Test
    void calculatePriceForConstructionWaste() {
        DroppedFractions df =
                new DroppedFractions(10, FractionType.CONSTRUCTION_WASTE);

        Price price = df.calculatePrice();

        assertEquals(new Price(1.5, Currency.EUR), price);
    }
}