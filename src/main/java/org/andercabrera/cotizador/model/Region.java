package org.andercabrera.cotizador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {
  @Id
  @Column(name = "id_region")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idRegion;

  @Column(name = "region")
  private String region;

  public Region() {
  }

  public Region(int idRegion, String region) {
    this.idRegion = idRegion;
    this.region = region;
  }

  public int getIdRegion() {
    return idRegion;
  }

  public void setIdRegion(int idRegion) {
    this.idRegion = idRegion;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }
}
