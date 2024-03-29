package de.tramotech.katas;

import de.tramotech.katas.model.Person;
import de.tramotech.katas.model.PhoneNumber;
import de.tramotech.katas.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
    void countElementFrequency() {
        int[] arr = {1, 2, 3, 4, 1, 2, 2, 3, 5, 5, 6, 7, 8, 8, 8};
        Map<Integer, Long> expectedMap = new HashMap<>();
        expectedMap.put(1, 2L);
        expectedMap.put(2, 3L);
        expectedMap.put(3, 2L);
        expectedMap.put(4, 1L);
        expectedMap.put(5, 2L);
        expectedMap.put(6, 1L);
        expectedMap.put(7, 1L);
        expectedMap.put(8, 3L);

        Map<Integer, Long> actual = app.countElementFrequency(arr);

        assertThat(actual).isEqualTo(expectedMap);
    }

    @Test
    void findDistinctCharacters() {
        List<String> words = Arrays.asList("hello", "world", "java", "stream");

        List<Character> actual = app.findDistinctCharacters(words);

        assertThat(actual).isEqualTo(List.of('h', 'e', 'l', 'o', 'w', 'r', 'd', 'j', 'a', 'v', 's', 't', 'm'));
    }

    @Test
    void transformNestedLists() {
        List<List<Integer>> input = Arrays.asList(
          Arrays.asList(3, 1, 4),
          Arrays.asList(1, 5, 9),
          Arrays.asList(2, 6, 5, 3)
        );

        List<Integer> actual = app.transformNestedLists(input);

        assertThat(actual).isEqualTo(List.of(1,4,9,16,25,36,81));
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

        assertThat(actual).isEqualTo(new Person("Sophia", 23));
    }



    @Test
    void getTotalAmountByTransactionType() {
        Map<String, Double> actual = app.getTotalAmountByTransactionType(createListOfTransactions());

        assertThat(actual.keySet()).hasSize(2).hasSameElementsAs(List.of("credit", "debit"));
        assertThat(actual.values()).hasSize(2).hasSameElementsAs(List.of(90.0, 569.0));
    }

    @Test
    void countPeopleByAge() {
        Map<Integer, Long> actual = app.countPeopleByAge(createListOfPerson2());

        assertThat(actual.keySet()).hasSize(2).hasSameElementsAs(List.of(25,30));
        assertThat(actual.values()).hasSize(2).hasSameElementsAs(List.of(2L,3L));
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

    @Test
    void filterSummerDates() {
        List<LocalDate> actual = app.filterSummerDates(generateDates());

        assertThat(actual).hasSameElementsAs(List.of(LocalDate.of(2022, 6, 20),
                LocalDate.of(2022, 7, 4),
                LocalDate.of(2022, 8, 25)));
    }

    @ParameterizedTest
    @MethodSource("findCommonElementsDataProvider")
    void findCommonElements(List<Integer> list1, List<Integer> list2, List<Integer> expected ) {
        List<Integer> actual = app.findCommonElements(list1, list2);
        assertThat(actual).containsSequence(expected);
    }

    @ParameterizedTest
    @MethodSource("findLongestWordDataProvider")
    void findLongestWord(List<String> words, String expected) {
        String actual = app.findLongestWord(words);

        assertThat(actual).isEqualTo(expected);
    }

    static Collection<Object[]> findLongestWordDataProvider() {
        return List.of(new Object[][] {
                { List.of("apple", "banana", "grapefruit", "orange", "watermelon"), "grapefruit" },
                { List.of("hello", "world", "java", "streams", "are", "cool"), "streams"},
                { List.of("hello", "world"), "hello"},
                { List.of("world", "hello"), "world"},
        });
    }

    static Collection<Object[]> findCommonElementsDataProvider() {
        return List.of(new Object[][] {
                { List.of(1, 3, 5, 7, 9), List.of(2, 3, 5, 7, 11), List.of(3, 5, 7) },
                { List.of(9, 7, 5, 3, 1), List.of(2, 3, 5, 7, 11), List.of(3, 5, 7) },
                { List.of(1, 1, 1, 2, 2), List.of(1, 3, 5), List.of(1) },
                { List.of(1, 2), List.of(3, 5), Collections.emptyList()},
                { Collections.emptyList(), List.of(3, 5), Collections.emptyList()},
                { List.of(1, 2), Collections.emptyList(), Collections.emptyList()},
        });
    }










    private List<Person> createListOfPerson() {
        return  List.of(
                new Person("Sophia", 23),
                new Person("Maximilian", 17),
                new Person("Emma", 19),
                new Person("Alexander", 18),
                new Person("Alexander", 21)

        );
    }

    private List<Person> createListOfPerson2() {
        return List.of(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("David", 30),
                new Person("Eva", 25)
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

    private List<LocalDate> generateDates() {
        return List.of(
                LocalDate.of(2022, 1, 10),
                LocalDate.of(2022, 2, 1),
                LocalDate.of(2022, 3, 14),
                LocalDate.of(2022, 4, 28),
                LocalDate.of(2022, 5, 19),
                LocalDate.of(2022, 6, 20),
                LocalDate.of(2022, 7, 4),
                LocalDate.of(2022, 8, 25),
                LocalDate.of(2022, 9, 5),
                LocalDate.of(2022, 10, 12),
                LocalDate.of(2022, 11, 16),
                LocalDate.of(2022, 12, 15)
        );
    }


    @ParameterizedTest(name = "str = \"{1}\"")
    @DisplayName("Sample tests")
    @CsvSource(textBlock = """
          true,  ooxx
          false, xooxx
          true,  ooxXm
          true,  zpzpzpp
          false, zzoo
          true,  xxxooo
          true,  xxxXooOo
          false, xxx23424esdsfvxXXOOooo
          false, xXxxoewrcoOoo
          false, XxxxooO
          true,  zssddd
          false, Xxxxertr34
          true,  ''
      """)
    void sampleTests(boolean expected, String input) {
        assertThat(app.getXo(input)).isEqualTo(expected);
    }

}