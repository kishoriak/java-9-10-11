package com.demo.student.service.dbimpl;

import com.demo.student.service1.StudentService;
import com.demo.student.model.Student;
import java.util.logging.*;

public class StudentDbService implements StudentService {

    private static Logger logger = Logger.getLogger("com.demo.student.service.dbimpl.StudentDbService");

    public String create(Student student) {
        logger.log(Level.INFO, "Creating new student ");
        return student.getRegistrationId();
    }

    public Student read(String registrationId) {
        logger.log(Level.INFO, "Reading student data from backend");
        return new Student();
    }

    public Student update(Student student) {
        logger.log(Level.INFO, "Updating student data");
        return student;
    }

    public String delete(String registrationId) {
        logger.log(Level.INFO, "Deleting student by id");
        return registrationId;
    }
}