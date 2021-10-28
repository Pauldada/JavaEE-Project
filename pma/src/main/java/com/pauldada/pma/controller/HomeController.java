package com.pauldada.pma.controller;

import com.pauldada.pma.dao.ProjectRepository;
import com.pauldada.pma.dao.StudentRepository;
import com.pauldada.pma.entities.Project;
import com.pauldada.pma.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String displayHome(Model model){

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects",projects);

        List<Student> students = studentRepository.findAll();
        model.addAttribute("students",students);
        return "main/home";
    }
}
