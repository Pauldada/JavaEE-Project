package com.pauldada.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pauldada.pma.dao.ProjectRepository;
import com.pauldada.pma.dao.StudentRepository;
import com.pauldada.pma.dto.ChartData;
import com.pauldada.pma.dto.StudentProject;
import com.pauldada.pma.entities.Project;
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
    public String displayHome(Model model) throws JsonProcessingException {

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects",projects);

        List<ChartData> projectStatusData=projectRepository.getProjectStatus();
        //用Object Mapper实现JSON的转化
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectStatusData);
        //[{"未开始",1}{"进行中",2}{"已完成",1}]
        model.addAttribute("projectStatusData",jsonString);

        List<StudentProject> studentProjects=studentRepository.studentProject();
        model.addAttribute("studentProjects",studentProjects);
        return "main/home";
    }
}
