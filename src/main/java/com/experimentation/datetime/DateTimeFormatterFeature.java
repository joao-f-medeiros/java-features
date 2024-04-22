package com.experimentation.datetime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class DateTimeFormatterFeature {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    DateTimeFormatter formatterFull = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

    ZonedDateTime zdtNow = ZonedDateTime.now();
    LocalDateTime ldtNow = LocalDateTime.now();
    System.out.println(ldtNow);
    System.out.println(zdtNow);

    String zdtFormatted = formatterFull.format(zdtNow);
    System.out.println(zdtFormatted);

    DateTimeFormatter formatterOfPattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
    String ldtFormatted = ldtNow.format(formatterOfPattern);
    System.out.println(ldtFormatted);

    TemporalAccessor ldtParsed = formatterOfPattern.parse("22-04-2024 17-27-14");
    LocalDateTime ldtFrom = LocalDateTime.from(ldtParsed);
    System.out.println(ldtFrom);

    DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH-mm-ss");
    TemporalAccessor ltParsed = formatterTime.parse("08-11-34");
    System.out.println(ltParsed);
    LocalTime ltFrom = LocalTime.from(ltParsed);
    System.out.println(ltFrom);
  }
}
