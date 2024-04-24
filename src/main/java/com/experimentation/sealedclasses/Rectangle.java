package com.experimentation.sealedclasses;

public final class Rectangle extends GeometricFigure {

  private Double side = 4.0;
  private Double height = 3.0;

  public Double getSide() {
    return side;
  }

  public Double getHeight() {
    return height;
  }

  @Override
  public double calculateArea() {
    return 0;
  }

}
