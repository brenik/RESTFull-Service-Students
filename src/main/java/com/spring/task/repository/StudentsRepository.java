package com.spring.task.repository;

import com.spring.task.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
    Student findStudentById (int id);
}
