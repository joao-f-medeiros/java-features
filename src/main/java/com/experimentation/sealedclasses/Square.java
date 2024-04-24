package com.experimentation.sealedclasses;

// Can be final, sealed or non-sealed
public final class Square extends GeometricFigure {

  private Double side = 4.0;

  public Double getSide() {
    return side;
  }

  @Override
  public double calculateArea() {
    return 0;
  }

}
