package com.mini.project.mini_project.service.serviceImp;

import com.mini.project.mini_project.dto.authentication.authRequest.DTORegisterResponse;
import com.mini.project.mini_project.dto.authentication.authRequest.UserRegistrationRequest;
import com.mini.project.mini_project.entity.Users;
import com.mini.project.mini_project.jwt.JwtService;
import com.mini.project.mini_project.repository.UserRepository;
import com.mini.project.mini_project.service.UserService;
import com.mini.project.mini_project.validation.ExceptionValidation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return user;
    }

    public DTORegisterResponse registerUser(UserRegistrationRequest registrationRequest) throws Exception {
        Users users = userRepository.findByEmail(registrationRequest.getEmail());
        if (!Objects.isNull(users)){
            throw new Exception("You can not use duplicate email");
        }
        if (!ExceptionValidation.isValidName(registrationRequest.getUsername())){
            throw new Exception("You can not input number or special symbol");
        }
        if (!ExceptionValidation.isValidPhoneNumber(registrationRequest.getPhoneNumber())){
            throw new Exception("You can not input character and at least 8-10");
        }
        Users user = new Users();
        registrationRequest.requestRegisterLogin(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        DTORegisterResponse dtoRegisterResponse = new DTORegisterResponse();
        dtoRegisterResponse.responseDTORegister(userRepository.save(user));
        return dtoRegisterResponse;
    }
}
