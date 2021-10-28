package com.pauldada.pma.dao;

import com.pauldada.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Long> {
}
