package com.newtonprojectgroup.schoolmanagementsystem.Service;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCredentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SchoolUserDetails implements UserDetails {

    private String userName;
    private String passWord;
    private List<GrantedAuthority> grantedAuthority;

    public SchoolUserDetails(Credentials user) {
        this.userName = user.getUserName();
        this.passWord = new String(user.getPassword());
        grantedAuthority = new ArrayList<>();
        grantedAuthority.add(new SimpleGrantedAuthority(user.getUserPermission()));
    }

    public SchoolUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {

        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}
