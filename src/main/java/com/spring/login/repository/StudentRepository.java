package com.spring.login.repository;

import com.spring.login.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public Student findByEmail(String email);
}
