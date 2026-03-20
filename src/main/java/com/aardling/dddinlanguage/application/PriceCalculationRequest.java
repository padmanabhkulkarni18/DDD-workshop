package com.aardling.dddinlanguage.application;

import com.aardling.dddinlanguage.domain.DroppedFractions;

import java.util.List;

public record PriceCalculationRequest(String date, List<DroppedFractions> dropped_fractions, String person_id, String visit_id) {

}