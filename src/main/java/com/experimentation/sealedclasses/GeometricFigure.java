package com.experimentation.sealed_classes;

public sealed abstract class GeometricFigure permits Circle, Square, Rectangle {

  protected String color;

  public abstract double calculateArea();

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

}
