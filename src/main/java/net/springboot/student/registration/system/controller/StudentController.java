package net.springboot.student.registration.system.controller;

import net.springboot.student.registration.system.model.Student;
import net.springboot.student.registration.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Create student API
    @PostMapping("/students")
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


}
