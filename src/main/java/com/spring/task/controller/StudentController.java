package com.spring.task.controller;

import com.spring.task.domain.Student;
import com.spring.task.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentsRepository repository;

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = {"application/json"})
    @ResponseBody
    public Student getStudent(@PathVariable int studentId) {
        return repository.findStudentById(studentId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json", produces = {"application/json"})
    @ResponseBody
    public List getStudentsList() {
        return repository.findAll();
    }


    @RequestMapping(value = "/edit/{studentId}", method = RequestMethod.PUT, headers = "Accept=application/json", produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public Boolean editStudent(@RequestBody Student student) {
        Student studentEdit =new Student();
        studentEdit.id  = repository.findStudentById(student.id).id;
        studentEdit.setName(student.name);
        studentEdit.setSurname(student.surname);
        repository.save(studentEdit);
        return true;
    }

    @RequestMapping(value = "/{add}", method = RequestMethod.POST, headers = "Accept=application/json", produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public boolean addStudent(@RequestBody Student student) {
        repository.save(student);
        return true;
    }

    @RequestMapping(value = "/delete/{studentId}")
    @ResponseBody
    public boolean deleteStudent(@PathVariable int  studentId) {
        repository.delete(studentId);
        return true;
    }

}
