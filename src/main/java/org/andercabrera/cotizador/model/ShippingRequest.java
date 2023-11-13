package org.andercabrera.cotizador.model;

public class ShippingRequest {
  private double weight;
  private double height;
  private double width;
  private double length;
  private int idCountry;
  private int idRegion;
  private String userPlan;

  public ShippingRequest() {}

  public ShippingRequest(double weight, double height, double width, double length, int idCountry, int idRegion,
    String userPlan) {
    this.weight = weight;
    this.height = height;
    this.width = width;
    this.length = length;
    this.idCountry = idCountry;
    this.idRegion = idRegion;
    this.userPlan = userPlan;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public int getIdCountry() {
    return idCountry;
  }

  public void setIdCountry(int idCountry) {
    this.idCountry = idCountry;
  }

  public int getIdRegion() {
    return idRegion;
  }

  public void setIdRegion(int idRegion) {
    this.idRegion = idRegion;
  }

  public String getUserPlan() {
    return userPlan;
  }

  public void setUserPlan(String userPlan) {
    this.userPlan = userPlan;
  }
}
