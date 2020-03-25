package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name = "idstudent")
public class Student extends Person {

    @Column(name="student_semester")
    private int semester;

    @ManyToOne
    @JoinColumn(name="student_program_id", nullable=false)
    private Program enlistedProgram;

    @OneToMany(mappedBy = "gradedStudent")
    private List<StudentGrade> studentGrades;

    public Student() {
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Program getEnlistedProgram() {
        return enlistedProgram;
    }

    public void setEnlistedProgram(Program enlistedProgram) {
        this.enlistedProgram = enlistedProgram;
    }

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }
}
