package com.experimentation.general;

import com.experimentation.sealed_classes.Circle;
import com.experimentation.sealed_classes.GeometricFigure;
import com.experimentation.sealed_classes.Rectangle;
import com.experimentation.sealed_classes.Square;

public class SwitchFeatures {

  private enum WEEK_DAY {
    SUNDAY, MONDAY, TUESDAY, WEDNESSDAY, THURSDAY, FRIDAY, SATURDAY
  };

  public static void main(String[] args) {
    System.out.println(oldSwitchCode(WEEK_DAY.MONDAY));

    System.out.println(newSwitchCode(WEEK_DAY.SATURDAY));

    // Java 17 and 21
    GeometricFigure figure = new Circle();
    System.out.println(oldSwitchCaseWithSealedClasses(figure));

    System.out.println(newSwitchCaseWithSealedClasses(figure));

    System.out.println(newSwitchFormatterPattern(10));
  }

  private static String newSwitchCode(WEEK_DAY day) {
    String result;

    // Java 14 - Can use body inside of lambda functions
    result = switch (day) {
      case MONDAY:
      case TUESDAY:
      case WEDNESSDAY:
      case THURSDAY:
      case FRIDAY:
        yield "Work Day";
      case SATURDAY:
      case SUNDAY:
        yield "Weekend";
    };
    System.out.println("Using yield: " + result);

    // Java 14 - Can use body inside of lambda functions
    switch (day) {
      // Multicase labels
      case MONDAY, TUESDAY, WEDNESSDAY, THURSDAY, FRIDAY -> result = "Work Day";
      case SATURDAY, SUNDAY -> result = "Weekend";
      default -> {
        System.out.println("Any code");
        result = "Day not recognized";
      }
    }
    System.err.println("Using lambda: " + result);

    // Java 14 - Can not use body inside of lambda functions
    return switch (day) {
      case MONDAY, TUESDAY, WEDNESSDAY, THURSDAY, FRIDAY -> "Work Day";
      case SATURDAY, SUNDAY -> "Weekend";
      default -> "Day not recognized";
    };
  }

  // Java 21 - Switch for Sealed Classes
  private static double newSwitchCaseWithSealedClasses(GeometricFigure figure) {
    return switch (figure) {
      case null -> 0.0;
      case Circle c -> c.getRadio() * c.getRadio() * Math.PI;
      case Square s -> s.getSide() * s.getSide();
      default -> 0.0;
    };
  }

  // Java 21 - Switch for var types
  private static String newSwitchFormatterPattern(Object obj) {
    return switch (obj) {
      case null -> "null";
      case Integer i when i < 100 -> String.format("int %d", i);
      case Long l when l.byteValue() == 0 -> String.format("int %d", l);
      case Double d -> String.format("int %f", d);
      case String s -> String.format("int %s", s);
      default -> obj.toString();
    };
  }

  private static double oldSwitchCaseWithSealedClasses(GeometricFigure figure) {
    if (figure instanceof Circle circle) {
      return circle.getRadio() * circle.getRadio() * Math.PI;
    }
    if (figure instanceof Square square) {
      return square.getSide() * square.getSide();
    }
    if (figure instanceof Rectangle rectangle) {
      return rectangle.getSide() * rectangle.getHeight();
    }
    return 0.0;
  }

  private static String oldSwitchCode(WEEK_DAY day) {
    String result;
    switch (day) {
      case MONDAY:
      case TUESDAY:
      case WEDNESSDAY:
      case THURSDAY:
      case FRIDAY:
        result = "Work Day";
        break;
      case SATURDAY:
      case SUNDAY:
        result = "Weekend";
        break;
      default:
        result = "Day not recognized";
        break;
    }
    return result;
  }
}
