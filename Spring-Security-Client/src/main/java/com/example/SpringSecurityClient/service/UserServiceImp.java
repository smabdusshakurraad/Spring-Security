package com.example.SpringSecurityClient.service;

import com.example.SpringSecurityClient.entity.User;
import com.example.SpringSecurityClient.entity.VerificationToken;
import com.example.SpringSecurityClient.model.UserModel;
import com.example.SpringSecurityClient.repository.UserRepository;
import com.example.SpringSecurityClient.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(UserModel userModel) { // Registering user
        User user = new User();
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLasatName());
        user.setEmail(userModel.getEmail());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole("USER");

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken
        = new VerificationToken(user,token); // creating new verification token

        verificationTokenRepository.save(verificationToken); // saving token into DB
    }
}
