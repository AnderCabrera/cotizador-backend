package org.andercabrera.cotizador.controller;

import java.util.List;

import org.andercabrera.cotizador.model.Region;
import org.andercabrera.cotizador.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/regions")
public class RegionController {
  
  @Autowired
  private RegionService regionService;

  @GetMapping(value="/", produces = "application/json")
  public List<Region> getRegions() {
    return regionService.list();
  }

  @PostMapping(value="/add", produces = "application/json", consumes = "application/json")
  public Region postMethodName(@RequestBody Region region) {
    return regionService.save(region);
  }
}
