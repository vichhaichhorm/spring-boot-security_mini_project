package com.mini.project.mini_project.dto.authentication.authRequest;

import com.mini.project.mini_project.entity.Users;
import com.mini.project.mini_project.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DTORegisterResponse {
    private String username;
    private String email;
    private Role role;
    private String phoneNumber;

    public void responseDTORegister(Users users){
        username = users.getUsername();
        email = users.getEmail();
        role = users.getRole();
        phoneNumber = users.getPhoneNumber();
    }
}
