package org.andercabrera.cotizador.model;

import org.apache.tomcat.util.http.parser.MediaType;

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

  @Column(name = "sub_plan")
  private String subPlan;

  @Column(name = "password")
  private String password;
  
  public User() {
  }

  public User(int id, String username, String subPlan, String password) {
    this.id = id;
    this.username = username;
    this.subPlan = subPlan;
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

  public String getSubPlan() {
    return subPlan;
  }

  public void setSubPlan(String subPlan) {
    this.subPlan = subPlan;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  
}
