package org.andercabrera.cotizador.controller;

import java.util.List;

import org.andercabrera.cotizador.model.User;
import org.andercabrera.cotizador.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/users", produces = "application/json")
  public List<User> getUsers() {
      return userService.list();
  }
  
  @PostMapping(value = "/users/add", consumes = "application/json", produces = "application/json")
  public User save(@RequestBody User user) {
    return userService.save(user);
  }
}
