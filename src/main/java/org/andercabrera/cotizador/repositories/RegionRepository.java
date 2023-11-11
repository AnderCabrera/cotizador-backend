package org.andercabrera.cotizador.repositories;

import org.andercabrera.cotizador.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
  
}
