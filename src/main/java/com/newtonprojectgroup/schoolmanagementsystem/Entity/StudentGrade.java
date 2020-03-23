package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;


@Entity
@Table(name="student_grade")
public class StudentGrade {

    @Id
    @Column(name="idgrade")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gradeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_idstudent")
    private Student gradedStudent;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grade_idcourse")
    private Course course;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grade")
    private Grade grade;

    public StudentGrade() {
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public Student getGradedStudent() {
        return gradedStudent;
    }

    public void setGradedStudent(Student gradedStudent) {
        this.gradedStudent = gradedStudent;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
