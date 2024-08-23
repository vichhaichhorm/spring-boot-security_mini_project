package com.mini.project.mini_project.service;

import com.mini.project.mini_project.dto.authentication.authRequest.UserRegistrationRequest;
import com.mini.project.mini_project.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    Users registerUser(UserRegistrationRequest registrationRequest);
}
