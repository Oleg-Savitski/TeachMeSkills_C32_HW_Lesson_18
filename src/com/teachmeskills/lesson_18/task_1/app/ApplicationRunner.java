package com.teachmeskills.lesson_18.task_1.app;

import com.teachmeskills.lesson_18.task_1.model.NumberCollectionProcessor;
import com.teachmeskills.lesson_18.task_1.service.RandomNumberGenerator;

import java.util.List;

/**Create a collection of the ArrayList class and fill it with elements of the random Integer type.
 Using Streams:
 - Remove duplicates
 - Print all even elements in the range from 7 to 17 (inclusive)
 - Multiply each element by 2
 - Sort and display the first 4 items
 - Display the number of items in the stream
 - Output the arithmetic mean of all the numbers in the stream
 */

public class ApplicationRunner {

    public static void main(String[] args) {

        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers();

        NumberCollectionProcessor.processAndPrintNumbers(randomNumbers);
    }
}