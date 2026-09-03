package com.sai.studentmanagement.controller;

import com.sai.studentmanagement.entity.Students;
import com.sai.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Students addStudent(@RequestBody Students student) {
       return studentService.addStudent(student);
    }

    @GetMapping("/all")
    public List<Students> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Use distinct paths to avoid ambiguous mapping between id and name
    @GetMapping("/stud/id/{id}")
    public Students getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/stud/name/{name}")
    public Students getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping(value="/stud/email/{email}", produces = "application/json")
    public Students getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @PutMapping("/update/{id}")
    public Students updateStudent(@PathVariable Integer id, @RequestBody Students student) {
       return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return studentService. deleteStudent(id);
    }
}
