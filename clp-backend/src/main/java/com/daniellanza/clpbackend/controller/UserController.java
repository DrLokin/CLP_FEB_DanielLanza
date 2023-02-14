package com.daniellanza.clpbackend.controller;

import com.daniellanza.clpbackend.data.User;
import com.daniellanza.clpbackend.dto.LoginRequest;
import com.daniellanza.clpbackend.dto.LoginResponse;
import com.daniellanza.clpbackend.dto.UserRegistration;
import com.daniellanza.clpbackend.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class UserController {

    private UserService userService;

    public ResponseEntity<User> register(@RequestBody UserRegistration registerForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(registerForm));
    }

    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest credentials, HttpSession session){
        Optional<LoginResponse> auth = userService.authenticateUser(credentials);

        if(!auth.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        session.setAttribute("user", auth.get());

        return ResponseEntity.ok(auth.get());

    }
}
