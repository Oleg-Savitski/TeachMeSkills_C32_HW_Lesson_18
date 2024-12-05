package com.teachmeskills.lesson_18.task_2.interaction;

import com.teachmeskills.lesson_18.task_2.exception.StudentNameException;

import java.util.Scanner;

public class InputManager implements AutoCloseable {
    private final Scanner scanner;

    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public String getStartLetter() throws StudentNameException {
        System.out.print("Enter the initial letter of the name: ");
        String input = scanner.nextLine();

        if (input.trim().length() != 1) {
            throw new StudentNameException(
                    "Incorrect input: '" + input + "'",
                    StudentNameException.ErrorType.INVALID_INPUT
            );
        }

        return input.trim().toUpperCase();
    }

    @Override
    public void close() {
        scanner.close();
    }
}