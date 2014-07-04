package com.asoftwareguy.examples.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class DateTimeExamples {

    public static void main(String... args) {
        LocalDate newYearsDay1982 = LocalDate.of(1982, 1, 1);
        System.out.println(newYearsDay1982.toString());

        int year = newYearsDay1982.getYear();
        assert year == 1982;

        Month month = newYearsDay1982.getMonth();
        assert month.equals(Month.JANUARY);

        int dayOfMonth = newYearsDay1982.getDayOfMonth();
        assert dayOfMonth == 1;

        boolean leapYear = newYearsDay1982.isLeapYear();
        assert !leapYear;

        int lengthOfMonth = newYearsDay1982.lengthOfMonth();
        assert lengthOfMonth == 31;

        // immutable; withYear returns a new LocalDate object
        LocalDate newYearsDay1988 = newYearsDay1982.withYear(1988);
        System.out.println(newYearsDay1988.toString());

        assert newYearsDay1982.getYear() == 1982;
        assert newYearsDay1988.getYear() == 1988;

        // Other useful classes:
        // Instant
        // LocalTime
        // LocalDateTime
        // OffsetTime
        // OffsetDateTime
        // ZonedDateTime
        // Year
        // YearMonth
        // MonthDay
        // Month
        // DayOfWeek


        // TemporalAdjuster: pre-defined, tested pieces of code to adjust temporal values
        TemporalAdjuster nextFriday = input -> input.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate fridayAfterNewYears1982 = newYearsDay1982.with(nextFriday);
        System.out.println(fridayAfterNewYears1982.toString());

        assert fridayAfterNewYears1982.getMonth() == Month.JANUARY;
        assert fridayAfterNewYears1982.getDayOfMonth() == 8;

        // loop through a range of LocalDates
        LocalDate startDate;
        LocalDate endDate = LocalDate.now();
        for (startDate = LocalDate.now().minusDays(7); startDate.isBefore(endDate); startDate = startDate.plusDays(1)) {
            System.out.println(startDate);
        }
    }
}