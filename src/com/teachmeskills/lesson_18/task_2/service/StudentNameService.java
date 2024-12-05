package com.teachmeskills.lesson_18.task_2.service;

import com.teachmeskills.lesson_18.task_2.exception.StudentNameException;
import com.teachmeskills.lesson_18.task_2.repository.StudentNameRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StudentNameService implements AutoCloseable {
    private final StudentNameRepository repository;

    public StudentNameService() {
        this.repository = new StudentNameRepository();
    }

    public void processAndDisplayNames(String startLetter) throws StudentNameException {

        List<String> allNames = repository.getStudentNames();
        List<String> filteredNames = allNames.stream()
                .filter(name -> name.toUpperCase().startsWith(startLetter))
                .sorted()
                .collect(Collectors.toList());

        if (filteredNames.isEmpty()) {
            throw new StudentNameException(
                    "Names with a letter '" + startLetter + "' not found",
                    StudentNameException.ErrorType.NAME_NOT_FOUND
            );
        }

        displayNames(startLetter, filteredNames);
    }

    public String getFirstSortedName(String startLetter) throws StudentNameException {
        List<String> allNames = repository.getStudentNames();

        return allNames.stream()
                .filter(name -> name.toUpperCase().startsWith(startLetter))
                .sorted()
                .findFirst()
                .orElseThrow(() -> new StudentNameException(
                        "Names with a letter '" + startLetter + "' not found",
                        StudentNameException.ErrorType.NAME_NOT_FOUND
                ));
    }

    private void displayNames(String startLetter, List<String> filteredNames) {
        System.out.println("Names starting with the letter " + startLetter + ":");
        filteredNames.forEach(System.out::println);
    }

    @Override
    public void close() {
    }
}