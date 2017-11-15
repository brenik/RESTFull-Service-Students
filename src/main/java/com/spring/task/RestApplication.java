package com.spring.task;

import com.spring.task.domain.Student;
import com.spring.task.repository.StudentsRepository;
import com.spring.task.service.StudentsLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		ApplicationContext contex = SpringApplication.run(RestApplication.class, args);
		StudentsRepository repository  = contex.getBean(StudentsRepository.class);

		List<Student> studentsList = StudentsLoader.create(15);
		repository.save(studentsList);
	}
}
