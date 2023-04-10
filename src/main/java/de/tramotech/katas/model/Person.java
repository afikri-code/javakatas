package de.tramotech.katas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
    private final String name;
    private final int age;
    private List<PhoneNumber> phoneNumberList;

}
