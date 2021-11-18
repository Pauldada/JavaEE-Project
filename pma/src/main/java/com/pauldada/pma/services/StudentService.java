package com.pauldada.pma.services;

import com.pauldada.pma.dao.StudentRepository;
import com.pauldada.pma.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
}
