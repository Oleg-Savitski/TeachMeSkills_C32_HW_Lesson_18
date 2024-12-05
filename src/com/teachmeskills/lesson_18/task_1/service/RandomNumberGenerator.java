package com.teachmeskills.lesson_18.task_1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.teachmeskills.lesson_18.task_1.utils.Constants.DEFAULT_BOUND;
import static com.teachmeskills.lesson_18.task_1.utils.Constants.DEFAULT_SIZE;

public class RandomNumberGenerator {

    public static List<Integer> generateRandomNumbers() {
        return generateRandomNumbers(DEFAULT_SIZE, DEFAULT_BOUND);
    }

    public static List<Integer> generateRandomNumbers(int size, int bound) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(bound));
        }

        return numbers;
    }
}