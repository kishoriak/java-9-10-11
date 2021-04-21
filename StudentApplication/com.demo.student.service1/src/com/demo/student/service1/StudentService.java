package com.demo.student.service1;

import com.demo.student.model.Student;

public interface StudentService {

    public String create(Student student);

    public Student read(String registrationId);

    public Student update(Student student);

    public String delete(String registrationId);
}