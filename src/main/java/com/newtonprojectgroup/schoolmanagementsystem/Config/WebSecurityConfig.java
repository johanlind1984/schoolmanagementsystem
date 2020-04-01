package com.newtonprojectgroup.schoolmanagementsystem.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
        .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, enabled FROM credentials WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, permission FROM credentials WHERE username = ?");

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/student").hasRole("STUDENT")
                .antMatchers("/teacher").hasRole("TEACHER")
                .antMatchers("/staff").hasRole("STAFF")
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
