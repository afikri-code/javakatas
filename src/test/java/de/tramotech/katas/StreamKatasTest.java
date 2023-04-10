package de.tramotech.katas;

import de.tramotech.katas.model.Person;
import de.tramotech.katas.model.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StreamKatasTest {
    @Test
    void getNamesOfAdults() {
        StreamKatas app = new StreamKatas();

        List<String> actual = app.getNamesOfAdults(createListOfPerson());

        assertThat(actual).hasSize(3).isEqualTo(List.of("Sophia", "Emma", "Alexander"));
    }

    @Test
    void getNamesOfAdultsInUpperCase() {
        StreamKatas app = new StreamKatas();

        List<String> actual = app.getNamesOfAdultsInUpperCase(createListOfPerson());

        assertThat(actual).hasSize(3).isEqualTo(List.of("SOPHIA", "EMMA", "ALEXANDER"));
    }

    @Test
    void sumOfOddIntegers() {
        StreamKatas app = new StreamKatas();

        int actual = app.sumOfOddIntegers(List.of(1,2,3,4,5,6,7,8,9));

        assertThat(actual).isEqualTo(25);
    }

    @Test
    void getTotalAmountByTransactionType() {
        StreamKatas app = new StreamKatas();

        Map<String, Double> actual = app.getTotalAmountByTransactionType(createListOfTransactions());

        assertThat(actual.keySet()).hasSize(2).contains("credit", "debit");
        assertThat(actual.values()).hasSize(2).contains(90.0, 569.0);
    }



    private List<Person> createListOfPerson() {
        return  List.of(
                new Person("Sophia", 21),
                new Person("Maximilian", 17),
                new Person("Emma", 19),
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