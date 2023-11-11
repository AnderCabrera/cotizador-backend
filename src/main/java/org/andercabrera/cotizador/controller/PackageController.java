package org.andercabrera.cotizador.controller;

import java.util.List;

import org.andercabrera.cotizador.model.Package;
import org.andercabrera.cotizador.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class PackageController {
  @Autowired
  private PackageService packageService;
  
  @GetMapping(value = "/packages", produces = "application/json")
  public List<Package> getPackages() {
      return packageService.list();
  }
  
  @PostMapping(value = "/packages/add", consumes = "application/json", produces = "application/json")
  public Package save(@RequestBody Package packageObj) {
    return packageService.save(packageObj);      
  }
}
