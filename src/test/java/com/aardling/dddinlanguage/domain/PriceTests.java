package com.aardling.dddinlanguage.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PriceTests {
    @Test
    void priceCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Price(-1, Currency.EUR));
    }

    @Test
    void testPriceAreEqual() {
        assertEquals(new Price(0, Currency.EUR), new Price(0, Currency.EUR));
    }

    @Test
    void pricesAreNotEqual() {
        assertNotEquals(new Price(0, Currency.EUR), new Price(1, Currency.EUR));
    }

    @Test
    void addPricesSuccessfully() {
        Price p1 = new Price(10, Currency.EUR);
        Price p2 = new Price(5, Currency.EUR);

        Price result = p1.addPrice(p2);

        assertEquals(new Price(15, Currency.EUR), result);
    }


    @Test
    void zeroFactoryMethod() {
        Price zero = Price.zero(Currency.EUR);

        assertEquals(new Price(0, Currency.EUR), zero);
    }

}
