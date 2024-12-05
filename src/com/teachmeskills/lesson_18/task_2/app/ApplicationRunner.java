package com.teachmeskills.lesson_18.task_2.app;

import com.teachmeskills.lesson_18.task_2.exception.StudentNameException;
import com.teachmeskills.lesson_18.task_2.interaction.InputManager;
import com.teachmeskills.lesson_18.task_2.service.StudentNameService;

/**Create a collection of the ArrayList class with
    the values of the names of all students in the group
  Using Streams:
  - Select all names starting with any letter entered from the console
    (regardless of uppercase/lowercase letters)
  - Sort and return the first element of the collection
  */

public class ApplicationRunner {

    public static void main(String[] args) {
        try (InputManager inputManager = new InputManager();
             StudentNameService service = new StudentNameService()) {

            String startLetter = inputManager.getStartLetter();

            service.processAndDisplayNames(startLetter);

            String firstSortedName = service.getFirstSortedName(startLetter);
            System.out.println("\nThe first name in the sorted list: " + firstSortedName);

        } catch (StudentNameException e) {
            System.err.println(e.getDetailedMessage());

            switch (e.getErrorType()) {
                case INVALID_INPUT:
                    System.err.println("Please enter one letter.");
                    break;
                case NAME_NOT_FOUND:
                    System.err.println("Try another letter.");
                    break;
                default:
                    System.err.println("An unexpected error occurred in the operation of the application.");
            }
        }
    }
}