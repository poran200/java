package com.test.demo.Ui;

import com.test.demo.model.Student;
import com.test.demo.repository.StudentRepository;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("student")
public class StudentView extends VerticalLayout {

    private StudentRepository studentRepository;

    Grid<Student> studentGrid;
    Binder<Student> studentBinder;

    public StudentView(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        studentGrid = new Grid<>();
        studentGrid
                .addColumn(Student::getId)
                .setHeader("student Id");
        studentGrid
                .addColumn(Student::getName)
                .setHeader("name");
        studentGrid
                .addColumn(Student::getAge)
                .setHeader("age");
        studentGrid
                .addColumn(student -> student.getAddress().getStudentaddress())
                .setHeader("Address");
        studentGrid.setItems(this.studentRepository.findAll());
        add(studentGrid);

    }
}
