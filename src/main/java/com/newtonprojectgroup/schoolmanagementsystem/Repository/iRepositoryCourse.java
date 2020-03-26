package com.newtonprojectgroup.schoolmanagementsystem.Repository;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Course;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositoryCourse extends JpaRepository<Course, Integer> {
}
