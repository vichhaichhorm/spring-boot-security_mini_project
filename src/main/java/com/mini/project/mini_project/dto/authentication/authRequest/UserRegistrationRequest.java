package com.mini.project.mini_project.dto.authentication.authRequest;


import com.mini.project.mini_project.entity.Users;
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
    public void requestRegisterLogin(Users users){
        users.setUsername(this.username);
        users.setEmail(this.email);
        users.setAddress(this.address);
        users.setPhoneNumber(this.phoneNumber);
        users.setRole(this.role);
        users.setPassword(this.password);
    }
}

