package com.newtonprojectgroup.schoolmanagementsystem.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.jar.JarOutputStream;

@Configuration
public class AuthenticationSuccesHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Set<String> authoritiesList = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if(authoritiesList.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin/");
        } else if (authoritiesList.contains("ROLE_STAFF")) {
            httpServletResponse.sendRedirect("/staff/");
        } else if (authoritiesList.contains("ROLE_TEACHER")) {
            httpServletResponse.sendRedirect("/teacher/");
        } else if (authoritiesList.contains("ROLE_STUDENT")) {
            httpServletResponse.sendRedirect("/student/");
        } else {
            httpServletResponse.sendRedirect("/error/");
        }
    }
}