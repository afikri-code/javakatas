package de.tramotech.katas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DateAndTimeKatasTest {

    DateAndTimeKatas app;
    @BeforeEach
    void setUp() {
        app = new DateAndTimeKatas();
    }

    @ParameterizedTest
    @MethodSource("ageDataProvider")
    public void testAgeCalculation(String birthdate, LocalDate today, String expectedAge) {
        String actualAge = app.calculateAge(birthdate, today);

        assertThat(expectedAge).isEqualTo(actualAge);
    }

    @ParameterizedTest
    @MethodSource("appointementDataProvider")
    void isValidAppointmentDate(LocalDateTime appointment, boolean expected) {
        assertThat(app.isValidAppointmentDate(appointment)).isEqualTo(expected);
    }

    static Collection<Object[]> appointementDataProvider() {
        return List.of(new Object[][] {
                { LocalDate.of(2023, 4, 17).atTime(10, 0), true }, // Monday
                { LocalDate.of(2023, 4, 22).atTime(11, 0), false }, // Saturday
                { LocalDate.of(2023, 4, 16).atTime(12, 30), false }, // Sunday
                { LocalDate.of(2023, 4, 17).atTime(8, 59), false }, // Monday
                { LocalDate.of(2023, 4, 17).atTime(17, 1), false } // Monday
        });
    }


    static Collection<Object[]> ageDataProvider() {
        return List.of(new Object[][] {
                { "13.04.1990", LocalDate.of(2023, 4, 13), "33 years, 0 months, 0 days" },
                { "31.12.1985", LocalDate.of(2023, 4, 13), "37 years, 3 months, 13 days" },
                { "29.02.2000", LocalDate.of(2023, 4, 13), "23 years, 1 months, 15 days" }
        });
    }

}