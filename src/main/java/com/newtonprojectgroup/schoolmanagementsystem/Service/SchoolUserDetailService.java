package com.newtonprojectgroup.schoolmanagementsystem.Service;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.reflect.generics.repository.FieldRepository;

import java.util.Optional;

@Service
public class SchoolUserDetailService implements UserDetailsService {

    @Autowired
    private iRepositoryCredentials repositoryCredentials;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Credentials> user = repositoryCredentials.findByUserName(userName);
        return user.map(SchoolUserDetails::new).get();
    }


}
