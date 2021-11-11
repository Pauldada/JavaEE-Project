package com.pauldada.pma.dao;

import com.pauldada.pma.dto.StudentProject;
import com.pauldada.pma.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    @Override
    public List<Student> findAll();

    @Query(nativeQuery = true,value = "SELECT s.name, s.wechat_id AS wechatId, COUNT(s.student_id) AS projectCount " +
            "FROM student AS s LEFT JOIN project_student AS ps ON s.student_id = ps.student_id " +
            "GROUP BY s.name, s.wechat_id ORDER BY 3 desc; ")
    List<StudentProject> studentProject();
}
