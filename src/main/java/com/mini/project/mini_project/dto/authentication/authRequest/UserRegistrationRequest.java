package com.mini.project.mini_project.dto.authentication.authRequest;


import com.mini.project.mini_project.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    private String username;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;
    private Role role;
}

