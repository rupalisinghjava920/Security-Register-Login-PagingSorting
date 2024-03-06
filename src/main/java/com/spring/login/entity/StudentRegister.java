package com.spring.login.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@ToString
@Table(name="studentRegister_tbl")
public class StudentRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String studentName;
    private String className1;
    private String fatherName;
    private String motherName;
    private String mobile;
    private String registerFees;
    private String admissionDate;
    private String address;
    private String country;


    public StudentRegister(long id, String studentName, String className1, String fatherName, String motherName, String mobile, String registerFees, String admissionDate, String address, String country) {
        this.id = id;
        this.studentName = studentName;
        this.className1 = className1;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.mobile = mobile;
        this.registerFees = registerFees;
        this.admissionDate = admissionDate;
        this.address = address;
        this.country = country;
    }

    public  long getId(Long id) {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName1() {
        return className1;
    }

    public void setClassName1(String className1) {
        this.className1 = className1;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegisterFees() {
        return registerFees;
    }

    public void setRegisterFees(String registerFees) {
        this.registerFees = registerFees;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
