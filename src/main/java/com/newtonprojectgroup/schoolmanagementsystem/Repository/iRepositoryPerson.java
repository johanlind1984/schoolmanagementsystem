package com.newtonprojectgroup.schoolmanagementsystem.Repository;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositoryPerson extends JpaRepository<Person, String> {

}
