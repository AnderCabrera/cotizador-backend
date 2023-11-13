package org.andercabrera.cotizador.services;

import java.util.List;
import java.util.Optional;

import org.andercabrera.cotizador.exceptions.BadCredentialsException;
import org.andercabrera.cotizador.model.UserRequest;
import org.andercabrera.cotizador.model.User;
import org.andercabrera.cotizador.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  /**
   * @return user from database
   */

  public List<User> list() {
    return userRepository.findAll();
  }

  /**
   * Create a new user Object and save it in database
   * @param user
   * @return success message
   */

  public User save(User user) {
    return userRepository.save(user);
  }

  /**
   * Search for a user in <strong>database</strong> throught id
   * @param id 
   * @return User Object
   */

  public User get(int id) {
    Optional<User> userOptional = userRepository.findById(id);

    if (userOptional.isEmpty()) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND
      );
    }

    return userOptional.get();
  }

  public User login(String username, String password) throws BadCredentialsException {
    User user = userRepository.findByUsernameAndPassword(username, password);

    if (user == null) {
      throw new BadCredentialsException("User not found");
    }

    if (!user.getPassword().equals(password)) {
      throw new BadCredentialsException("Invalid password");
    }

    return user;
  }

  public User register(User user) {
    if (userRepository.findByUsername(user.getUsername()) != null) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST, "Username already exists"
      );
    }
    
    return userRepository.save(user);
  }
}
