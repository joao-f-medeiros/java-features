package com.experimentation.sealed_classes;

public non-sealed class Circle extends GeometricFigure {

  private Double radio = 2.0;

  public Double getRadio() {
    return radio;
  }

  public void setRadio(Double radio) {
    this.radio = radio;
  }

  @Override
  public double calculateArea() {
    return 0;
  }

}
