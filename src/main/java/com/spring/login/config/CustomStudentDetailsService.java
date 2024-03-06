package com.spring.login.config;

import com.spring.login.entity.Student;
import com.spring.login.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomStudentDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student=studentRepository.findByEmail(username);
        if(student==null){
            throw new UsernameNotFoundException("Student not found");
        }else{
            return new CustomStudent(student);
        }
    }
}
