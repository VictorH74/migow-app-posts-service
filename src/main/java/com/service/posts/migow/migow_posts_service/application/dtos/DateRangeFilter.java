package com.service.posts.migow.migow_posts_service.application.dtos;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Getter
@Log4j2
@ToString
public class DateRangeFilter {
    private final Instant startDate;
    private final Instant endDate;

    public static DateRangeFilter of(String startDate, String endDate) {
        log.info("parsing dates: " + startDate + " | " + endDate);
        Instant parsedStartDate = parseOrDefault(startDate, Instant.EPOCH);
        Instant parsedEndDate = parseOrDefault(endDate, Instant.now());
        log.info("parsed dates: " + parsedStartDate + " | " + parsedEndDate);
        return new DateRangeFilter(parsedStartDate, parsedEndDate);
    }

    private static Instant parseOrDefault(String dateStr, Instant defaultInstant) {
        try {
            return Instant.parse(dateStr);
        } catch (Exception e) {
            return defaultInstant;
        }
    }

}
