package com.pauldada.pma.controller;

import com.pauldada.pma.dao.ProjectRepository;
import com.pauldada.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject=new Project();
        model.addAttribute("project",aProject);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model,Project project){
        projectRepository.save(project);
        return "redirect:/projects/new";
        //处理保存到数据库的行为
    }

}
