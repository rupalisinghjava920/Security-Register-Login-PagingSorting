package com.spring.login.service;

import com.spring.login.entity.Student;
import com.spring.login.entity.StudentRegister;
import com.spring.login.repository.StudentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Service
public  class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    @Override

    public Student saveStudent(Student student) {
       //String password=passwordEncoder.encode(student.getPassword());
       //student.setPassword(password);
      // student.setRole("ROLE_STUDENT");
       Student st= studentRepository.save(student);
        return st;
    }

    @Override
    public void removeSessionMessage() {
       HttpSession session=((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes()))
               .getRequest().getSession();
       session.removeAttribute("msg");
    }



}
