package com.example.SpringBootTest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    @Autowired
    public UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        return (userRepository.findByUsername(username) == null);
    }
}
