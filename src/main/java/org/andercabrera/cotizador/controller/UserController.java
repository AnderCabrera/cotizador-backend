package org.andercabrera.cotizador.controller;

import java.util.List;

import org.andercabrera.cotizador.model.UserRequest;
import org.andercabrera.cotizador.model.User;
import org.andercabrera.cotizador.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/", produces = "application/json")
  public List<User> getUsers() {
      return userService.list();
  }
  
  @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
  public User save(@RequestBody User user) {
    return userService.save(user);
  }

  @PostMapping(value="/login", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> postMethodName(@RequestBody UserRequest userRequest) {
    User user = userService.login(userRequest.getUsername(), userRequest.getPassword());
    return ResponseEntity.ok(user);
  }
  
  @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
  public User register(@RequestBody User user) {
    return userService.register(user);
  }
}
