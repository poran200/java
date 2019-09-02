package com.test.demo.Ui;

import com.test.demo.model.Student;
import com.test.demo.repository.StudentRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route("textview")
public class TextView extends VerticalLayout {
    Binder<Student> studentBinder;
    @Autowired
    private StudentRepository studentRepository;


    public TextView(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        studentBinder = new Binder<>();

        TextArea textArea = new TextArea();
        Optional<Student> student = this.studentRepository.findById(1);
        textArea.setValue("Name : " + student.get().getName()
                + "\nStudent age : " + student.get().getAge()
                + "\nAddress : " + student.get().getAddress().getStudentaddress()
        );
        textArea.setReadOnly(true);
        textArea.setMaxHeight("1000px");
        textArea.setMaxWidth("1000px");


//        textArea.setWidthFull();
//        textArea.setHeightFull();
        add(textArea);
    }
}
