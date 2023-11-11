package org.andercabrera.cotizador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "packages")
public class Package {
  @Id
  @Column(name = "id_package")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "weight")
  private int weight;

  @Column(name = "width")
  private int width;
  
  @Column(name = "height")
  private int height;

  @Column(name = "length")
  private int length;
  
  @ManyToOne
  @JoinColumn(name = "id_country_origin")
  private Country idCountryOrigin;
  
  @ManyToOne
  @JoinColumn(name = "id_country_destination")
  private Country idCountryDestination;

  public Package() {}

  public Package(int id, int weight, int width, int height, int length, Country idCountryOrigin,
      Country idCountryDestination) {
    this.id = id;
    this.weight = weight;
    this.width = width;
    this.height = height;
    this.length = length;
    this.idCountryOrigin = idCountryOrigin;
    this.idCountryDestination = idCountryDestination;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public Country getIdCountryOrigin() {
    return idCountryOrigin;
  }

  public void setIdCountryOrigin(Country idCountryOrigin) {
    this.idCountryOrigin = idCountryOrigin;
  }

  public Country getIdCountryDestination() {
    return idCountryDestination;
  }

  public void setIdCountryDestination(Country idCountryDestination) {
    this.idCountryDestination = idCountryDestination;
  }

  
}
