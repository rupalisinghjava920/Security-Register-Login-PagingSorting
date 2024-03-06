package com.spring.login.service;

import com.spring.login.entity.Student;
import com.spring.login.entity.StudentRegister;

import java.util.List;

public interface StudentService {

     public Student saveStudent(Student student);

    public void removeSessionMessage();



}
