package com.teachmeskills.lesson_18.task_1.model;

import com.teachmeskills.lesson_18.task_1.exception.NumberProcessingException;

import java.util.List;

public class NumberCollectionProcessor {

    public static void processAndPrintNumbers(List<Integer> numbers) {

        NumberProcessingException.validateCollection(numbers);

        try {
            List<Integer> distinctNumbers = numbers.stream()
                    .distinct()
                    .toList();

            System.out.println("The list after deleting duplicates:");
            distinctNumbers.forEach(System.out::println);

            System.out.println("\nEven elements in the range from 7 to 17:");
            distinctNumbers.stream()
                    .filter(NumberCollectionProcessor::isEvenInRange)
                    .forEach(System.out::println);

            System.out.println("\nElements after multiplication by 2:");
            List<Integer> multipliedNumbers = distinctNumbers.stream()
                    .filter(NumberCollectionProcessor::isEvenInRange)
                    .map(n -> n * 2)
                    .toList();
            multipliedNumbers.forEach(System.out::println);

            List<Integer> processedNumbers = multipliedNumbers.stream()
                    .sorted()
                    .limit(4)
                    .toList();

            System.out.println("\nThe first 4 items after sorting:");
            processedNumbers.forEach(System.out::println);

            int elementCount = processedNumbers.size();
            System.out.println("\nNumber of elements: " + elementCount);

            double averageValue = processedNumbers.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElseThrow(() -> new NumberProcessingException(
                            "Unable to calculate average",
                            NumberProcessingException.ErrorType.CALCULATION_ERROR
                    ));
            System.out.println("Arithmetic mean: " + averageValue);

        } catch (NumberProcessingException e) {
            System.err.println(e.getDetailedMessage());

            switch (e.getErrorType()) {
                case NULL_INPUT:
                    System.err.println("Null input is not allowed.");
                    break;
                case EMPTY_COLLECTION:
                    System.err.println("Cannot process an empty collection.");
                    break;
                case CALCULATION_ERROR:
                    System.err.println("Failed to perform calculations.");
                    break;
                default:
                    System.err.println("An unexpected error occurred.");
            }
        }
    }

    private static boolean isEvenInRange(Integer number) {
        return number % 2 == 0 && number >= 7 && number <= 17;
    }
}