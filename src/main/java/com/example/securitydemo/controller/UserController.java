package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitydemo.dto.UserDto;

import jakarta.validation.Valid;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // @PostMapping("/users")
    // public String createUser(@RequestParam String username,
    //         @RequestParam String password,
    //         @RequestParam String role) {

    //     JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

    //     if (userDetailsManager.userExists(username)) {
    //         return "user already exists";
    //     }

    //     UserDetails user = User.withUsername(username)
    //             .password(passwordEncoder.encode(password))
    //             .roles(role)
    //             .build();
    //     userDetailsManager.createUser(user);

    //     return "User created Sucessfully";
    // }
    @PostMapping("/public/users")
    @CrossOrigin(origins = "http://localhost:5173")
 public String createUser(@RequestBody UserDto userDTO) {
     JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
     if (userDetailsManager.userExists(userDTO.getUsername())) {
         return "User already exists";
     }

     UserDetails user = User.withUsername(userDTO.getUsername())
             .password(passwordEncoder.encode(userDTO.getPassword()))
             .roles(userDTO.getRole())
             .build();
     userDetailsManager.createUser(user);

     return "User created successfully";
 }
    


}
