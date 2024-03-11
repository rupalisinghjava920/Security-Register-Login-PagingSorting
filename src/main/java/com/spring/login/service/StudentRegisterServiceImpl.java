package com.spring.login.service;

import com.spring.login.entity.StudentRegister;
import com.spring.login.repository.StudentRegisterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentRegisterServiceImpl implements StudentRegisterService {

    @Autowired
    private StudentRegisterRepository studentRegisterRepository;

    @Override
    public StudentRegister saveStudentRegister(StudentRegister studentRegister) {
        StudentRegister register=this.studentRegisterRepository.save(studentRegister);
        return register;
    }

    @Override
    public List<StudentRegister> getAllStudentRegisters() {
        List<StudentRegister> list= (List<StudentRegister>) this.studentRegisterRepository.findAll();
        return list;
    }

    @Override
    public StudentRegister updateStudentRegisterById(Long id) {
        Optional<StudentRegister> optional=studentRegisterRepository.findById(id);
        System.out.println(id);
        StudentRegister studentRegister=null;
        if(optional.isPresent()){
            studentRegister=optional.get();
        }else{
            throw new RuntimeException("StudentRegister not found for id :: "+ id);
        }
        return studentRegister;
    }

    @Override
    public void deleteStudentRegisterById(Long id) {
      this.studentRegisterRepository.deleteById(id);
    }

    @Override
    public Page<StudentRegister> findPaginated(int pageNo, int pageSize,String sortField,String sortDirection) {
        Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();

        Pageable pageable= PageRequest.of(pageNo - 1,pageSize,sort);
        return this.studentRegisterRepository.findAll(pageable);
    }

    @Override
    public List<StudentRegister> getStudentRegisterByStudentName(String studentName) {
        return studentRegisterRepository.findByStudentName(studentName);
    }

}
