package com.aardling.dddinlanguage.application;

public record PriceCalculationResponse(double price_amount, String price_currency, String visit_id, String person_id) {
    
}
