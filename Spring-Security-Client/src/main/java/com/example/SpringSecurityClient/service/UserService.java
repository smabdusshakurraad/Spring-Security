package com.example.SpringSecurityClient.service;

import com.example.SpringSecurityClient.entity.User;
import com.example.SpringSecurityClient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel); // To register user

    void saveVerificationTokenForUser(String token, User user); // to save token for user
}
