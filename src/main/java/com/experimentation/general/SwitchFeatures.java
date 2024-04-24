package com.experimentation.general;

public class SwitchFeatures {

  private enum WEEK_DAY {
    SUNDAY, MONDAY, TUESDAY, WEDNESSDAY, THURSDAY, FRIDAY, SATURDAY
  };

  public static void main(String[] args) {
    System.out.println(oldSwitchCode(WEEK_DAY.MONDAY));

    System.out.println(newSwitchCode(WEEK_DAY.SATURDAY));
  }

  private static String newSwitchCode(WEEK_DAY day) {
    String result;

    // Can use body inside of lambda functions
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

    // Can use body inside of lambda functions
    switch (day) {
      case MONDAY, TUESDAY, WEDNESSDAY, THURSDAY, FRIDAY -> result = "Work Day";
      case SATURDAY, SUNDAY -> result = "Weekend";
      default -> {
        System.out.println("Any code");
        result = "Day not recognized";
      }
    }
    System.err.println("Using lambda: " + result);

    // Can not use body inside of lambda functions
    return switch (day) {
      case MONDAY, TUESDAY, WEDNESSDAY, THURSDAY, FRIDAY -> "Work Day";
      case SATURDAY, SUNDAY -> "Weekend";
      default -> "Day not recognized";
    };
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
