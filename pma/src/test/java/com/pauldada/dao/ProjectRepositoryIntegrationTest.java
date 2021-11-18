package com.pauldada.dao;

import com.pauldada.pma.PmaApplication;
import com.pauldada.pma.dao.ProjectRepository;
import com.pauldada.pma.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = PmaApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:schema.sql","classpath:data.sql"}),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,scripts = {"classpath:drop.sql"})
})
public class ProjectRepositoryIntegrationTest {
    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void ifNewProjectSaved_thenSuccess(){
        Project newProject = new Project("新项目","已完成","测试描述");
        projectRepository.save(newProject);

        assertEquals(5,projectRepository.findAll().size());
    }
}
