package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name = "idstudent")
public class Student extends Person {

    @Id
    @Column(name="idstudent")
    private String studentId;

    @Column(name="student_semester")
    private int semester;

    @ManyToOne
    @JoinColumn(name="student_program_id", nullable=false)
    private Program enlistedProgram;

    public Student() {
    }

    @Override
    public String getStudentId() {
        return studentId;
    }

    @Override
    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
}
