package com.example.SpringBootTest.user;

import com.example.SpringBootTest.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Service
@Validated
public class UserService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public Validator validator;

    public UserModel findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserModel findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Integer addUser(UserModel user) {
        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserModel> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException(sb.toString(), violations);
        }
        UserModel newUser = userRepository.save(user);
        return newUser.getId();
    }
}