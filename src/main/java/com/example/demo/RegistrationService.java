package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private CustomUserDetailsService customUserDetailsService;
    private EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValid = emailValidator
                .test(request.getEmail());
        if (!isValid) {
            throw new IllegalStateException("email not valid");
        }
        return  customUserDetailsService.signUpUser(
                new User(
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword()
                )
        );
    }
}
