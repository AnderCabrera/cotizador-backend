package org.andercabrera.cotizador.services;

import java.util.List;
import java.util.Optional;

import org.andercabrera.cotizador.model.Package;
import org.andercabrera.cotizador.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PackageService {
  
  @Autowired
  private PackageRepository packageRepository;

  /**
   * @return list of packages from <strong>database</strong> 
   */

  public List<Package> list() {
    return packageRepository.findAll();
  }

  /**
   * Create a new package Object and save it in database
   * @param packageObj
   * @return success message
   */

  public Package save(Package packageObj) {
    return packageRepository.save(packageObj);
  }

  /**
   * Search for a package in <strong>database</strong> throught id
   * @param id 
   * @return Package Object
   */
  
  public Package get(int id) {
    Optional<Package> packageOptional = packageRepository.findById(id);

    if (packageOptional.isEmpty()) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND
      );
    }

    return packageOptional.get();
  }
}
