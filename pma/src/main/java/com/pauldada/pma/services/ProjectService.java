package com.pauldada.pma.services;

import com.pauldada.pma.dao.ProjectRepository;
import com.pauldada.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public List<Project> getAll(){
        return projectRepository.findAll();
    }

}
