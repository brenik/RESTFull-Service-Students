package com.spring.task.service;

import com.spring.task.domain.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StudentsLoader {
    private static String[] names = { "Britney","Sebastian", "Jessica", "Hayden", "Hayden","Amelia", "Amelia", "Kendall", "Issac", "Drake", "Isabella","Isabella", "Jessica","Olivia", "Scarlett" };
    private static String[] surnames = { "Spears","Taylor", "Patel", "Hudson", "Powell", "Bell", "Stein", "Roach", "Cummings", "Cabrera", "Cabrera","Spears", "Roach","Taylor", "Johansson" };
    public static List<Student> create(int size) {

        Student student = new Student();
        List<Student> students = new LinkedList<Student>();
        for (int x = 0; x < size; x++) {
            students.add(StudentsLoader.create());
        }

        return students;
    }



    public static Student create() {
        Student student = new Student();
        student.setName(names[ThreadLocalRandom.current().nextInt(1, names.length)]);
        student.setSurname(surnames[ThreadLocalRandom.current().nextInt(1, surnames.length)]);
        return student;


    }
}
