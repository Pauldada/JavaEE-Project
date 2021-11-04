package com.pauldada.pma.entities;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String name;
    private String wechatId;
    private String email;

    @ManyToOne(
            cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "project_id")
    private Project project;

    public Student(){

    }

    public Student(String name, String wechatId, String email) {
        this.name = name;
        this.wechatId = wechatId;
        this.email = email;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
