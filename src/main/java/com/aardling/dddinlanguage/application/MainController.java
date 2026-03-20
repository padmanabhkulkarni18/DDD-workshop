package com.aardling.dddinlanguage.application;

import com.aardling.dddinlanguage.domain.Currency;
import com.aardling.dddinlanguage.domain.DroppedFractions;
import com.aardling.dddinlanguage.domain.FractionType;
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

        double total = 0;
        for (DroppedFractions droppedFraction : request.dropped_fractions()) {
            FractionType type = droppedFraction.fractionType();
            double pricePerKg = type.getPricePerKg();
            total+= droppedFraction.amount_dropped() * pricePerKg;
            System.out.println(type + " price per kg: " + pricePerKg);
        }

        return ResponseEntity.ok(new PriceCalculationResponse(total, "EUR",request.visit_id(),request.person_id()));
    }

    private record StatusResponse(String status) {

    }
}
