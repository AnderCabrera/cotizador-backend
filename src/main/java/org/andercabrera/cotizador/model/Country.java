package org.andercabrera.cotizador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Countries")
public class Country {
  @Id
  @Column(name = "id_country")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "country")
  private String country;

  @Column(name = "region")
  private String region;

  @Column(name = "price")
  private int price;

  public Country() {}

  public Country(int id, String country, String region, int price) {
    this.id = id;
    this.country = country;
    this.region = region;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  
}
