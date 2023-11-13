package org.andercabrera.cotizador.repositories;

import org.andercabrera.cotizador.model.UserRequest;
import org.andercabrera.cotizador.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  public User findByUsernameAndPassword(String username, String password);
  public User findByUsername(String username);
}
