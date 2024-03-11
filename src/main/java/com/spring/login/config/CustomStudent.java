//package com.spring.login.config;
//
//import com.spring.login.entity.Student;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.Collection;
//
//public class CustomStudent implements UserDetails {
//    public CustomStudent(Student student) {
//        this.student = student;
//    }
//
//    private Student student;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(student.getRole());
//        return Arrays.asList(authority) ;
//    }
//
//    @Override
//    public String getPassword() {
//        return student.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return student.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
