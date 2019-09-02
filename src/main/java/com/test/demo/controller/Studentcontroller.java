package com.test.demo.controller;

import com.test.demo.model.Address;
import com.test.demo.model.Student;
import com.test.demo.repository.AddressRepository;
import com.test.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Studentcontroller {
    private StudentRepository studentRepository;

    public Studentcontroller(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("students")
    public ResponseEntity<List<Student>> findall() {
        List<Student> studentList = studentRepository.findAll();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            ResponseEntity<Student> ok = ResponseEntity.ok(optionalStudent.get());
            return ok;
        }
        return (ResponseEntity<Student>) ResponseEntity.status(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Address address = new Address("dhaka");
        Student optionalStudent = studentRepository.save(student);
        studentRepository.findById(optionalStudent.getId()).map(
                student1 -> {
                    address.setStudent(student);
                    addressRepository.save(address);
                    return optionalStudent;
                });

        return ResponseEntity.ok(student);
    }

}
