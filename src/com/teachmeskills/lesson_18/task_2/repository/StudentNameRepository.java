package com.teachmeskills.lesson_18.task_2.repository;

import com.teachmeskills.lesson_18.task_2.exception.StudentNameException;

import java.util.Arrays;
import java.util.List;

public class StudentNameRepository {
    private final List<String> names;

    public StudentNameRepository() {
        this.names = Arrays.asList(

                "Anna", "Alexander", "Artem",
                "Boris", "Bella", "Marina",
                "Andrey", "Bella", "Bella",
                "Victor", "valentina", "Valentina",
                "Oleg", "Kirill", "artem",
                "Rita", "Michael", "ekaterina",
                "Sergey", "vlad", "Vladimir"
        );
    }

    public List<String> getStudentNames() throws StudentNameException {
        if (names.isEmpty()) {
            throw new StudentNameException(
                    "The list of names is empty, create a list of names!",
                    StudentNameException.ErrorType.EMPTY_NAME_LIST
            );
        }
        return names;
    }
}