package de.tramotech.katas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(expectedAge, actualAge);
    }

    static Collection<Object[]> ageDataProvider() {
        return List.of(new Object[][] {
                { "13.04.1990", LocalDate.of(2023, 4, 13), "33 years, 0 months, 0 days" },
                { "31.12.1985", LocalDate.of(2023, 4, 13), "37 years, 3 months, 13 days" },
                { "29.02.2000", LocalDate.of(2023, 4, 13), "23 years, 1 months, 15 days" }
        });
    }

}