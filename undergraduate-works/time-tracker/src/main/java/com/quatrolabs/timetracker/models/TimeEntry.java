package com.quatrolabs.timetracker.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeEntry {

    private String description;
    private String startDatetime;
    private String endDatetime;

    public TimeEntry(String description, String startDatetime, String endDatetime) {
        this.description = description;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getElapsedTime() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date datetimeStart, datetimeEnd;
        String elapsedTime;

        try {
            datetimeStart = dateFormat.parse(this.startDatetime);
            datetimeEnd = dateFormat.parse(this.endDatetime);
        } catch (ParseException e) {
            return "";
        }

        long diffInMillis = Math.abs(datetimeEnd.getTime() - datetimeStart.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        elapsedTime = String.format("%d dia(s)", diff);
        if (diff <= 0) {
            diff = TimeUnit.HOURS.convert(diffInMillis, TimeUnit.MILLISECONDS);
            elapsedTime = String.format("%d hora(s)", diff);
        }
        if (diff <= 0) {
            diff = TimeUnit.MINUTES.convert(diffInMillis, TimeUnit.MILLISECONDS);
            elapsedTime = String.format("%d minuto(s)", diff);
        }

        return elapsedTime;
    }

}
