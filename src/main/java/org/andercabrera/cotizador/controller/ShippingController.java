package org.andercabrera.cotizador.controller;

import java.util.HashMap;

import org.andercabrera.cotizador.model.Country;
import org.andercabrera.cotizador.model.ShippingRequest;
import org.andercabrera.cotizador.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {
  @Autowired
  private CountryService countryService;

  public double calculateCost(double weight, int rate, double height, double width, double length, int discount) {
    return ((weight * rate) + 1.66 * height * length * width - discount * 0.5 * weight);
  }

  public int calculateDiscount(String userPlan) {
    if (userPlan == "PREMIUM")
      return 5;
    else if (userPlan == "SUPER_PREMIUM")
      return 10;

    return 0;
  }

  @PostMapping(value = "/fee", produces = "application/json", consumes = "application/json")
  public double getFee(@RequestBody ShippingRequest shippingRequest) {
    HashMap<String, Integer> plans = new HashMap<String, Integer>();
    plans.put("FREE", 0);
    plans.put("PREMIUM", 5);
    plans.put("SUPER_PREMIUM", 10);

    Country country = countryService.get(shippingRequest.getIdCountry());

    return calculateCost(shippingRequest.getWeight(), country.getPrice(), shippingRequest.getHeight(),
        shippingRequest.getWidth(), shippingRequest.getLength(), plans.get(shippingRequest.getUserPlan()));
  }
}
