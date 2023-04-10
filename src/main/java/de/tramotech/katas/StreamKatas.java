package de.tramotech.katas;

import de.tramotech.katas.model.Person;
import de.tramotech.katas.model.Transaction;

import java.util.List;
import java.util.Map;
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
                .filter(p->p.getAge() >= 18)
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    /*
        public List<String> getNamesOfAdultsInUpperCase(List<Person> people);
    */
    public List<String> getNamesOfAdultsInUpperCase(List<Person> people) {
        return people.stream().filter(p->p.getAge() >= 18)
                .map(person -> person.getName().toUpperCase())
                .distinct()
                .collect(Collectors.toList());
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
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getType,Collectors.summingDouble(Transaction::getAmount)));
    }


}
