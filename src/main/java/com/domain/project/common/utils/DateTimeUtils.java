package com.domain.project.common.utils;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public final class DateTimeUtils {
    public static ZonedDateTime now() {
        return ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    private DateTimeUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
