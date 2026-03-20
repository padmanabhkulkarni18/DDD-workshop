package com.aardling.dddinlanguage.domain;

import java.util.Objects;

public record Price(double amount, Currency currency) {
    public Price {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(currency);
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    public static Price zero(Currency currency) {
        return new Price(0, currency);
    }

    public Price addPrice(Price other){
        return new Price(this.amount+ other.amount, this.currency);
    }
}
