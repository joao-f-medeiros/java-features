package com.experimentation.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeApi {

  public static void main(String[] args) {
    // LocalDate - Represents only a date without anything else
    LocalDate ldNow = LocalDate.now();
    System.out.println(ldNow);
    LocalDate birthday = LocalDate.of(1986, Month.OCTOBER, 31);
    System.out.println(birthday);

    // LocalTime - Represents only a time without anything else
    LocalTime ltNow = LocalTime.now();
    System.out.println(ltNow);
    LocalTime time = LocalTime.of(10, 30, 40);
    System.out.println(time);

    // LocalDateTime - Represents only a date and time without anything else
    LocalDateTime ldtNow = LocalDateTime.now();
    System.out.println(ldtNow);
    LocalDateTime ldtBirthday = LocalDateTime.of(birthday, time);
    System.out.println(ldtBirthday);

    // Instant - Represents an instant in time line always in GMT/UTC time
    // Very good to represent an instant in time line but without Date information
    Instant iNow = Instant.now();
    System.out.println(iNow);
    Instant iEpoch = Instant.ofEpochMilli(500000000000000L);
    System.out.println(iEpoch);

    // ZonedDateTime - Represents a complete calendar, with date, time and timezone
    // Useful when the timezone information is well known
    ZonedDateTime zdtNow = ZonedDateTime.now();
    System.out.println(zdtNow);
    ZoneId montevideoZone = ZoneId.of("America/Montevideo");
    ZonedDateTime zdtBirthday = ZonedDateTime.of(ldtBirthday, montevideoZone);
    System.out.println(zdtBirthday);

    // Instant and ZonedDateTime
    ZonedDateTime atZone = iNow.atZone(ZoneId.of("America/Sao_Paulo"));
    System.out.println(iNow);
    System.out.println(atZone);
  }
}
