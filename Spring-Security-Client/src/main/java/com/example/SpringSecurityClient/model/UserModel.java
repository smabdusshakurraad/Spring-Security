package com.example.SpringSecurityClient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String firstName;
    private String lasatName;
    private String email;
    private String password;
    private String matchingPassword;
}
