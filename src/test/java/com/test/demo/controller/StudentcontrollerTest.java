package com.test.demo.controller;

import com.test.demo.model.Address;
import com.test.demo.model.Student;
import com.test.demo.repository.AddressRepository;
import com.test.demo.repository.StudentRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentcontrollerTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    @Ignore
    void findallstudent() {
        List<Student> studentList = studentRepository.findAll();
        studentList.forEach(System.out::println);

    }

    @Test
    void findallAdress() {

        List<Address> addresses = addressRepository.findAll();
        addresses.forEach(System.out::println);


    }

    @Test
    void findbyId() {
        Optional<Student> student = studentRepository.findById(1);
        assert student != null;
        student.get();
    }

}