package de.tramotech.katas;

import de.tramotech.katas.model.Person;
import de.tramotech.katas.model.PhoneNumber;
import de.tramotech.katas.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StreamKatasTest {

    StreamKatas app;
    @BeforeEach
    void setUp() {
        app = new StreamKatas();
    }

    @Test
    void sumOfOddIntegers() {
        int actual = app.sumOfOddIntegers(List.of(1,2,3,4,5,6,7,8,9));

        assertThat(actual).isEqualTo(25);
    }

    @Test
    void getNamesOfAdults() {
        List<String> actual = app.getNamesOfAdults(createListOfPerson());

        assertThat(actual).hasSize(3).hasSameElementsAs(List.of("Sophia", "Emma", "Alexander"));
    }

    @Test
    void getNamesOfAdultsInUpperCase() {
        List<String> actual = app.getNamesOfAdultsInUpperCase(createListOfPerson());

        assertThat(actual).hasSize(3).hasSameElementsAs(List.of("SOPHIA", "EMMA", "ALEXANDER"));
    }

    @Test
    void findOldestPerson() {
        Person actual = app.findOldestPerson(createListOfPerson());

        assertThat(actual).isEqualTo(new Person("Sophia", 21));
    }



    @Test
    void getTotalAmountByTransactionType() {
        Map<String, Double> actual = app.getTotalAmountByTransactionType(createListOfTransactions());

        assertThat(actual.keySet()).hasSize(2).contains("credit", "debit");
        assertThat(actual.values()).hasSize(2).contains(90.0, 569.0);
    }

    @Test
    void flattenList() {
        List<List<Integer>> list = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6), List.of(7, 8, 9));

        List<Integer> actual = app.flattenList(list);

        assertThat(actual).hasSize(9).hasSameElementsAs(List.of(1,2,3,4,5,6,7,8,9));
    }

    @Test
    void flattenNestedCollection() {
        List<String> actual = app.flattenNestedCollection(createListOfPersonWithTelephonNumber());

        assertThat(actual).hasSameElementsAs(List.of("929-1234", "325-5678", "929-1234", "325-5678", "423-1254", "777-7777"));
    }




    private List<Person> createListOfPerson() {
        return  List.of(
                new Person("Sophia", 21),
                new Person("Maximilian", 17),
                new Person("Emma", 19),
                new Person("Alexander", 18)
        );
    }

    private List<Person> createListOfPersonWithTelephonNumber() {
        return  List.of(
                new Person("Sophia", 21, List.of(new PhoneNumber("929-1234"), new PhoneNumber("325-5678"))),
                new Person("Maximilian", 17, List.of(new PhoneNumber("929-1234"), new PhoneNumber("325-5678"), new PhoneNumber("423-1254"))),
                new Person("Emma", 19, List.of(new PhoneNumber("777-7777"))),
                new Person("Alexander", 18)
        );
    }

    private List<Transaction> createListOfTransactions() {
        return  List.of(
                new Transaction("credit", 170.0),
                new Transaction("debit", 40.0),
                new Transaction("credit", 99.0),
                new Transaction("credit", 300.0),
                new Transaction("debit", 50.0)
        );
    }
}