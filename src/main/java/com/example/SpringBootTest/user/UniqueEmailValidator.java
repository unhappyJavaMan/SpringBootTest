package com.example.SpringBootTest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    public UserRepository userRepository;


    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return (userRepository.findByEmail(email) == null);
    }
}
