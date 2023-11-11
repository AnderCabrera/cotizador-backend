package org.andercabrera.cotizador.services;

import java.util.List;
import java.util.Optional;

import org.andercabrera.cotizador.model.Region;
import org.andercabrera.cotizador.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RegionService {
  
  @Autowired
  private RegionRepository regionRepository;

  public List<Region> list() {
    return regionRepository.findAll();
  }

  public Region save(Region region) {
    return regionRepository.save(region);
  }

  public Region get(int id) {
    Optional<Region> regionOptional = regionRepository.findById(id);

    if (regionOptional.isEmpty()) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND
      );
    }
    
    return regionOptional.get();
  }
}
