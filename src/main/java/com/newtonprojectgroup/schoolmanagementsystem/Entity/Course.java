package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {

    @Id
    @Column(name="idcourse")
    private int courseID;

    @Column(name="course_name")
    private String courseName;

    //@ManyToMany()
    // List<Program> programList;

    public Course() {
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
