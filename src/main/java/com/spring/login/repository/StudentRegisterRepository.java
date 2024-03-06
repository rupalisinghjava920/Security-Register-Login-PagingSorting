package com.spring.login.repository;

import com.spring.login.entity.StudentRegister;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegisterRepository extends JpaRepository<StudentRegister,Long> {

}
