package de.tramotech.katas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateAndTimeKatas {

    /**
     * Calculates the age in years between the specified birth date and the specified date.
     *
     * @param birthdate the birth date to calculate the age from
     * @param today the date to calculate the age to
     * @return a string representing the age in years between the two dates
     * @throws IllegalArgumentException if the birth date is after the specified date
     */
    public String calculateAge(String birthdate, LocalDate today) throws IllegalArgumentException{

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(birthdate, formatter);
        if (date.isAfter(today)) {
            throw new IllegalArgumentException("Birth date must be on or before the specified date");
        }
        Period period = Period.between(date, today);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        return String.format("%d years, %d months, %d days", years, months, days );
    }

    /**
     * checks whether the date is on weekdays (Monday-Friday) and within the hours of 9:00 AM and 5:00 PM
     * @param date the datetime to be checked
     * @return returns true if it represents a weekday and is within the allowed hours for appointments, and false otherwise.
     */
    public boolean isValidAppointmentDate(LocalDateTime date) {
        int dayOfWeek = date.getDayOfWeek().getValue();
        if(dayOfWeek > 5) {
            return false;
        }
        int hour = date.getHour();
        return hour >= 9 && hour < 17;
    }

}
