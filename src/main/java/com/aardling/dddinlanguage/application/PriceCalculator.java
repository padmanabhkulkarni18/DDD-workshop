package com.aardling.dddinlanguage.application;

public class PriceCalculator {
  public PriceCalculationResponse calculate(PriceCalculationRequest request) {
    return new PriceCalculationResponse(1, "EUR", request.visit_id(), request.person_id());
  }
}