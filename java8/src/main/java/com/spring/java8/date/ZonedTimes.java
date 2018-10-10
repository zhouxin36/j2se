package com.spring.java8.date;

import java.time.*;

public class ZonedTimes {
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());

        ZonedDateTime apollo11launch = ZonedDateTime.of(1969,7,16,9,32,0,0,ZoneId.of("Asia/Dubai"));
        System.out.println("apollo11launch:" +apollo11launch);

        Instant instant = apollo11launch.toInstant();
        System.out.println("instant: " + instant);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        System.out.println("zonedDateTime: " + zonedDateTime);

        ZonedDateTime skipped = ZonedDateTime.of(LocalDate.of(2013,3,31), LocalTime.of(2,30),ZoneId.of("America/Belize"));
        System.out.println("skipped: " + skipped);

        ZonedDateTime ambiguous = ZonedDateTime.of(LocalDate.of(2013,10,27),LocalTime.of(2,30),ZoneId.of("Etc/GMT-2"));
        ZonedDateTime anHourLater = ambiguous.plusHours(1);

        System.out.println("ambiguous: " + ambiguous);
        System.out.println("anHourLater: " + anHourLater);

        ZonedDateTime meeting = ZonedDateTime.of(LocalDate.of(2013,10,31),LocalTime.of(14,30),ZoneId.of("America/Argentina/Catamarca"));
        System.out.println("meeting: " + meeting);
        ZonedDateTime nextMeeting = meeting.plus(Duration.ofDays(7));
        System.out.println("nextMeeting: " + nextMeeting);
        nextMeeting = meeting.plus(Period.ofDays(7));
        System.out.println("nextMeeting: " +nextMeeting);

    }
}
