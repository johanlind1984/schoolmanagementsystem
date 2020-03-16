package com.newtonprojectgroup.schoolmanagementsystem.Repository;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRepositoryCredentials extends JpaRepository<Credentials, String> {
}
