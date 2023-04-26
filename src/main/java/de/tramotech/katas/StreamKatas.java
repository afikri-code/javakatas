package de.tramotech.katas;

import de.tramotech.katas.model.Person;
import de.tramotech.katas.model.PhoneNumber;
import de.tramotech.katas.model.Transaction;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: Ahmed Fikri
 *
 */
public class StreamKatas
{
    /*
        Write a method that takes in a list of integers and returns the sum of all odd integers in the list.
        The method signature should be:
        public int sumOfOddIntegers(List<Integer> numbers);
     */
    public int sumOfOddIntegers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n%2 != 0).mapToInt(Integer::intValue).sum();
    }

    /*
       Kata: Filter and Map
       Problem Statement
       You are given a list of Person objects. Each Person has the following attributes:
         * name: a string representing the person's name
         * age: an integer representing the person's age
       Your task is to write a method that takes in a list of Person objects and returns a list of the names of people who are older than 18.
       Then, you should modify your method to return a list of the names of people who are older than 18, in all uppercase letters.
       Signature
       The method signature should be:
       public List<String> getNamesOfAdults(List<Person> people);
       public List<String> getNamesOfAdultsInUpperCase(List<Person> people);
       Constraints
         * The input list of people may be empty.
         * The output list should not contain any duplicates.
         * You should use Java streams to solve this kata.
     */
    public List<String> getNamesOfAdults(List<Person> people) {
        return people.stream()
                .filter(p-> p!= null && p.getAge() >= 18)
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    /*
        public List<String> getNamesOfAdultsInUpperCase(List<Person> people);
    */
    public List<String> getNamesOfAdultsInUpperCase(List<Person> people) {
        return people.stream().filter(p-> p != null && p.getName() != null && p.getAge() >= 18)
                .map(person -> person.getName().toUpperCase())
                .distinct()
                .collect(Collectors.toList());
    }

    /*
        Kata: Finding the Oldest Person in a List
        In this kata, you will practice using Java's Stream API to find the oldest person in a list of persons.
     */
    public Person findOldestPerson(List<Person> people) {
        return people.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);
    }

    /*
        Suppose you have a list of transactions, where each transaction has a type and an amount. Write a method that
        returns the total amount of transactions for each transaction type, sorted by transaction type in ascending order.
        Here's the signature of the method:
        public Map<String, Double> getTotalAmountByTransactionType(List<Transaction> transactions);
        And here's the Transaction class:
        class Transaction {
          String type;
          double amount;
          ..
         }
     */
    public Map<String, Double> getTotalAmountByTransactionType(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType,Collectors.summingDouble(Transaction::getAmount)));
    }

    /*
        Kata: Flattening a List of Lists
        In this kata, you will practice using Java's Stream API to flatten a list of lists.
    */
    public  List<Integer> flattenList(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /*
        Kata: Flattening a Nested Collection
        In this kata, you will practice using Java's Stream API to flatten a list of lists.
    */
    public  List<String> flattenNestedCollection(List<Person> people) {
        return people.stream()
                .flatMap(list -> Optional.ofNullable(list.getPhoneNumberList())
                        .orElse(Collections.emptyList()).stream())
                .map(PhoneNumber::getNumber)
                .collect(Collectors.toList());
    }

    /**
     * Returns a filtered list of LocalDate objects that fall within the months of June, July, and August.
     *
     * @param dates The list of LocalDate objects to filter.
     * @return A filtered list of LocalDate objects that fall within the months of June, July, and August.
     */
    public List<LocalDate> filterSummerDates(List<LocalDate> dates) {
        return dates.stream()
                .filter(date -> List.of(6, 7, 8).contains(date.getMonthValue()))
                .collect(Collectors.toList());
    }

    /**
     * Counts the number of people in each age group in the given list of people.
     *
     * @param listOfPerson a list of {@link Person} objects
     * @return a {@code Map<Integer, Long>} where the keys are the ages and the values are the counts
     * @throws NullPointerException if the input list is {@code null}
     */
    public Map<Integer, Long> countPeopleByAge(List<Person> listOfPerson) {
        return listOfPerson.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
    }

    /**
     * Returns a list of integers containing the common elements of the two input lists, in ascending order.
     *
     * @param list1 the first input list of integers
     * @param list2 the second input list of integers
     * @return a list containing the common elements of both lists, in ascending order
     */
    public List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .filter(list2::contains)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }


    /**
     * Finds the longest word in a list of words using Java Streams.
     *
     * @param words a list of strings where each string represents a word
     * @return the longest word in the input list, or an empty string if the input list is empty
     */
    public String findLongestWord(List<String> words) {
        Optional<String> longestWord = words.stream()
                .max(Comparator.comparing(String::length));
        return longestWord.orElse("");
    }

}
