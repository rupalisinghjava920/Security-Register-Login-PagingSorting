package com.spring.login.service;

import com.spring.login.entity.StudentRegister;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentRegisterService {


    public StudentRegister saveStudentRegister(StudentRegister studentRegister);

    List<StudentRegister> getAllStudentRegisters();

    public StudentRegister updateStudentRegisterById(Long id);

    void deleteStudentRegisterById(Long id);

    Page<StudentRegister> findPaginated(int pageNo , int pageSize,String sortField,String sortDirection);

     public List<StudentRegister> getStudentRegisterByStudentName(String studentName);


}
