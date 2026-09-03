package com.sai.studentmanagement.service;

import com.sai.studentmanagement.entity.Students;
import com.sai.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Students addStudent(Students student) {
        return studentRepository.save(student);
    }

    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }


    public Students getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Students updateStudent(Integer id, Students student) {
//        Students existingStudent = studentRepository.findById(id).get();
//        existingStudent.setName(student.getName());
//        existingStudent.setEmail(student.getEmail());
//        existingStudent.setPhone(student.getPhone());
//        return studentRepository.save(existingStudent);
               Students stud=studentRepository.findById(id).get();
               stud.setName(student.getName());
               stud.setEmail(student.getEmail());
               stud.setAddr(student.getAddr());
               return studentRepository.save(stud);
    }

    public String deleteStudent(Integer id) {
        Students stud=studentRepository.findById(id).get();
        studentRepository.delete(stud);
        return "Student deleted successfully";
    }

    public Students getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public Students getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
