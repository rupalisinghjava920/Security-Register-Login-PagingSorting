package com.spring.login.controller;

import ch.qos.logback.classic.Logger;
import com.spring.login.entity.Student;
import com.spring.login.entity.StudentRegister;
import com.spring.login.repository.StudentRegisterRepository;
import com.spring.login.repository.StudentRepository;
import com.spring.login.service.StudentRegisterService;
import com.spring.login.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;


    @Autowired
    private StudentRegisterRepository studentRegisterRepository;
    @Autowired
    private StudentRegisterService studentRegisterService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String index(Model model) {

//        List<StudentRegister> studentRegisters = studentRegisterService.getAllStudentRegisters(keyword);
//
//        model.addAttribute("studentRegisterList",studentRegisters);
//        model.addAttribute("keyword",keyword);
        return findPaginated(1, "studentName", "asc", model);
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

//    @GetMapping("/student/profile")
//    public String profile(Principal p, Model m) {
//        String email = p.getName(); // rupali123@gmail.com
//        System.out.println(email);
//        Student student = studentRepository.findByEmail(email); // rupali@gmail.com
//        String username = student.getEmail();
//        System.out.println(username);
//        m.addAttribute("student", student);
//
//        if (username.equals(email)) {
//            return "profile";
//        } else {
//            return "login";
//        }
//    }
    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/saveRegister")
    public String saveStudent(@ModelAttribute Student student, HttpSession session) {
        System.out.println("testing");
        Student st = studentService.saveStudent(student);
        if (st != null) {
            //System.out.println("Save is success");
            session.setAttribute("msg", "Register successfully");

        } else {
            //System.out.println("error in server");
            session.setAttribute("msg", "Something wrong server");
        }
        return "redirect:/register";
    }

    @GetMapping("/student/getStudentRegister")
    public String showAddStudentForm(Model model) {
        StudentRegister studentRegister = new StudentRegister();
        System.out.println("its working fine1");
        model.addAttribute("studentRegister", new StudentRegister());
        System.out.println("its working fine");
        return "redirect:/student/profile";
    }


    @PostMapping("/student/addStudentRegister")
    public String processAddStudentForm(@ModelAttribute StudentRegister studentRegister, HttpSession session) {
        StudentRegister sr = studentRegisterService.saveStudentRegister(studentRegister);
        if (sr != null) {
            session.setAttribute("msg", "Save StudentRegister successfully");
        } else {
            //System.out.println("error in server");
            session.setAttribute("msg", "Something wrong server");
        }
        return "redirect:/";
    }

    @GetMapping("/updateStudentRegister/{id}")
    public String showUpdate(@PathVariable(value = "id") Long id, Model model) {
        System.out.println("testing");
        StudentRegister studentRegister = studentRegisterService.updateStudentRegisterById(id);
        model.addAttribute("studentRegister", studentRegister);
        return "home";
    }

    @PostMapping("student/edit/{id}")
    public String updateStudentRegister(@PathVariable("id") Long id,StudentRegister studentRegister,
                                        BindingResult result, Model model) {

        studentRegister.setId(id);
        studentRegisterService.saveStudentRegister(studentRegister);
        return "home";
    }

    @GetMapping("/deleteStudentRegister/{id}")
    public String deleteStudentRegisterById(@PathVariable(value = "id") Long id) {
        System.out.println("delete print");
        this.studentRegisterService.deleteStudentRegisterById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {


        Page<StudentRegister> page = studentRegisterService.findPaginated(pageNo, 5, sortField, sortDir);
        List<StudentRegister> studentRegisterList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("studentRegisterList", studentRegisterList);
        return "index";
    }

    @GetMapping("/search/filterByName")
    public String searchByName(@RequestParam("studentName") String studentName, Model model) {
            List<StudentRegister> list = studentRegisterService.getStudentRegisterByStudentName(studentName);
            System.out.println("studentRegisterList "+list);
            model.addAttribute("studentRegisterList", list);
        return "index";
    }


}
