package net.springboot.student.registration.system.controller;

import net.springboot.student.registration.system.exception.ResourceNotFound;
import net.springboot.student.registration.system.model.Student;
import net.springboot.student.registration.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // Get student by Id
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long Id) {
        Student student = studentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFound("Student doesn't exist with ID :" + Id));

        return ResponseEntity.ok(student);
    }




}
