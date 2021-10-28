package com.pauldada.pma.dao;

import com.pauldada.pma.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    @Override
    public List<Student> findAll();
}
