package com.arolla.legacy.testing.quotebot;

import java.util.Calendar;
import java.util.Date;

public class TimeProvider implements ITimeProvider {
    @Override
    public long getMilliseconds() {
        return new Date().getTime() - new Date(2000, Calendar.JANUARY, 1)
                .getTime();
    }
}
