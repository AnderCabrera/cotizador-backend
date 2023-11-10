package org.andercabrera.cotizador.repositories;

import org.andercabrera.cotizador.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {

}
