package com.newtonprojectgroup.schoolmanagementsystem.Repository;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Course;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositoryPersonType extends JpaRepository<PersonType, Integer> {
}
