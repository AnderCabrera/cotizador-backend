package org.andercabrera.cotizador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  @Column(name = "id_user")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "username")
  private String username;

  @Column(name = "user_plan")
  private String userPlan;

  @Column(name = "password")
  private String password;
  
  public User() {
  }

  public User(int id, String username, String userPlan, String password) {
    this.id = id;
    this.username = username;
    this.userPlan = userPlan;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserPlan() {
    return userPlan;
  }

  public void setUserPlan(String userPlan) {
    this.userPlan = userPlan;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
