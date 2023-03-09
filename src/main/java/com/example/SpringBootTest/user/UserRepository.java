package com.example.SpringBootTest.user;

import com.example.SpringBootTest.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
    UserModel findByUsername(String Username);
}
