package com.example.SpringSecurityClient.event.listener;

import com.example.SpringSecurityClient.entity.User;
import com.example.SpringSecurityClient.event.RegistrationCompleteEvent;
import com.example.SpringSecurityClient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j // for log
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification token for the User with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        //Send Mail to the user
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?Token="
                        + token;

        //sendVerificationEmail() can be implemented
        log.info("Click the link to verify your account: {}",
                url);
    }
}
