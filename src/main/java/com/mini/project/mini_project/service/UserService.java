package com.mini.project.mini_project.service;

import com.mini.project.mini_project.dto.authentication.authRequest.DTORegisterResponse;
import com.mini.project.mini_project.dto.authentication.authRequest.UserRegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    DTORegisterResponse registerUser(UserRegistrationRequest registrationRequest) throws Exception;
}
