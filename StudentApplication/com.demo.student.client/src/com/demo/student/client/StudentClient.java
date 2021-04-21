package com.demo.student.client;


import com.demo.student.service1.StudentService;
import com.demo.student.service.dbimpl.StudentDbService;
import com.demo.student.model.Student;
import com.demo.student.service.dbimpl.StudentDbService;

public class StudentClient {

    public static void main(String[] args) {
        StudentService service = new StudentDbService();
        service.create(new Student());
        service.read("17SS0001");
        service.update(new Student());
        service.delete("17SS0001");
        System.out.println("in main method");
    }
}