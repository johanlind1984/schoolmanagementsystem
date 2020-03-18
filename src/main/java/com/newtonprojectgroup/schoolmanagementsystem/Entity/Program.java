package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="program")
public class Program {

    @Id
    @Column(name="idprogram")
    private int programId;

    @Column(name="program_name")
    private String programName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "program_course",
            joinColumns = { @JoinColumn(name = "idprogram_course_course_id") },
            inverseJoinColumns = { @JoinColumn(name = "idprogram_course_program_id") }
    )
    private List<Course> courseList;

    @OneToMany(mappedBy="enlistedProgram")
    private List<Student> studentList;


    public Program() {
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
