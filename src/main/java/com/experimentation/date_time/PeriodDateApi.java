package com.experimentation.date_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodDateApi {

  public static void main(String[] args) {
    periodFeatures();

    durationFeatures();
  }

  private static void durationFeatures() {
    // Duration - Represents a duration in time, using hour, minutes, seconds
    // We cannot pass Duration to LocaDate
    Duration ofDays = Duration.ofDays(1);
    System.out.println(ofDays);

    Duration ofMinutes = Duration.ofMinutes(500);
    System.out.println(ofMinutes);

    LocalTime ltNow = LocalTime.now();
    LocalTime lt = LocalTime.of(19, 50, 0);
    Duration between = Duration.between(ltNow, lt);
    System.out.println(between);
  }

  private static void periodFeatures() {
    // Period - Represents a period of dates in at least one day to years
    // We cannot pass Period to LocaTime
    Period period = Period.of(1, 5, 2);
    System.out.println(period);

    // Immutable - Every change made in a period, must be assigned to a variable
    Period twoYears = Period.ofYears(2);
    System.out.println(twoYears);

    LocalDate ld = LocalDate.of(2000, 1, 1);
    LocalDate ld2 = ld.plusWeeks(2).plusDays(2).plusMonths(3);
    Period ldBetweenFromPeriod = Period.between(ld, ld2);
    System.out.println(ldBetweenFromPeriod);

    Period ldBetweenFromLocalDate = ld.until(ld2);
    System.out.println(ldBetweenFromLocalDate);

    // LocalDate - Period can be used to change other objects data
    LocalDate ldTwoYearsLater = ld.plus(twoYears);
    System.out.println(ldTwoYearsLater);
  }
}
