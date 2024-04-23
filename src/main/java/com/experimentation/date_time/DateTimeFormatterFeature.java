package com.experimentation.date_time;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

public class DateTimeFormatterFeature {

  public static void main(String[] args) {
    Locale.setDefault(Locale.forLanguageTag("pt-BR"));

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

    problemOfLMTForOldDates();
  }

  /*
   * Before 1900, there weren't a clear definition of the correct time zones time
   * that we have today. To solve this, the date used considers the LMT - Local
   * Mean Time that has a try to find the correct differences. The Date API
   * doesn't use the LMT but the new Date Time API does. That's why the
   * difference.
   */
  private static void problemOfLMTForOldDates() {
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

    LocalDate localDate = LocalDate.of(1899, 8, 6);
    LocalTime localTime = LocalTime.of(23, 59);
    ZoneId zoneId = ZoneId.of("America/Sao_Paulo");

    ZonedDateTime zdt = ZonedDateTime.of(localDate, localTime, zoneId);
    Date date = new Date(zdt.toInstant().toEpochMilli());

    System.out.println(formatter.format(zdt));
    System.out.println(dateFormat.format(date));

    System.out.println(zdt.getOffset());
    System.out.println(date.getTimezoneOffset());
  }
}
