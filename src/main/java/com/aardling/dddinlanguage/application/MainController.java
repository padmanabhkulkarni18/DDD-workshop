package com.aardling.dddinlanguage.application;

import com.aardling.dddinlanguage.domain.Currency;
import com.aardling.dddinlanguage.domain.DroppedFractions;
import com.aardling.dddinlanguage.domain.FractionType;
import com.aardling.dddinlanguage.domain.Price;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MainController {
    @GetMapping("/")
    public ResponseEntity<StatusResponse> home() {
        return ResponseEntity.ok(new StatusResponse("OK"));
    }

    @PostMapping("/startScenario")
    public ResponseEntity<StatusResponse> internalInit() {
        return ResponseEntity.ok(new StatusResponse("OK"));
    }

    @PostMapping("/calculatePrice")
    public ResponseEntity<PriceCalculationResponse> calculatePrice(@RequestBody PriceCalculationRequest request) {

        Price totalPrice = Price.zero(Currency.EUR);
        for (DroppedFractions droppedFraction : request.dropped_fractions()) {
            Price price = droppedFraction.calculatePrice();
            totalPrice = totalPrice.addPrice(price);
            System.out.println(" price : " + price);
        }

        return ResponseEntity.ok(new PriceCalculationResponse(totalPrice.amount(), Currency.EUR.toString(),request.visit_id(), request.person_id()));
    }

    private record StatusResponse(String status) {

    }
}
