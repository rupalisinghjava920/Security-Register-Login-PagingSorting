package com.spring.login.repository;

import com.spring.login.entity.StudentRegister;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRegisterRepository extends JpaRepository<StudentRegister,Long> {

    List<StudentRegister> findByStudentName(String studentName);

}
