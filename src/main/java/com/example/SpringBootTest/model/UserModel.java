package com.example.SpringBootTest.model;

import javax.persistence.*;

@Entity
@Table(name = "userinfo")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column
    private String password;
}
