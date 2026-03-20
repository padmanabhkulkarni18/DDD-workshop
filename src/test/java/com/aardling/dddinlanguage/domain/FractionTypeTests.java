package com.aardling.dddinlanguage.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTypeTests {

    @Test
    void fromStringGreenWaste() {
        FractionType type = FractionType.fromString("green waste");

        assertEquals(FractionType.GREEN_WASTE, type);
    }

    @Test
    void fromStringConstructionWaste() {
        FractionType type = FractionType.fromString("construction waste");

        assertEquals(FractionType.CONSTRUCTION_WASTE, type);
    }

    @Test
    void fromStringIsCaseInsensitive() {
        FractionType type = FractionType.fromString("Green Waste");

        assertEquals(FractionType.GREEN_WASTE, type);
    }

    @Test
    void unknownFractionThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> FractionType.fromString("metal"));
    }

    @Test
    void pricePerKgIsCorrect() {
        assertEquals(0.10, FractionType.GREEN_WASTE.getPricePerKg());
        assertEquals(0.15, FractionType.CONSTRUCTION_WASTE.getPricePerKg());
    }
}