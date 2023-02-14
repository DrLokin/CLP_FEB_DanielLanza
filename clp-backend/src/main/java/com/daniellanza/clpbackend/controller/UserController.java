package com.daniellanza.clpbackend.controller;

import com.daniellanza.clpbackend.data.User;
import com.daniellanza.clpbackend.dto.LoginRequest;
import com.daniellanza.clpbackend.dto.LoginResponse;
import com.daniellanza.clpbackend.dto.UserRegistration;
import com.daniellanza.clpbackend.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"}, allowCredentials = "true")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistration registerForm){
        User user = userService.saveUser(registerForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest credentials, HttpSession session){
        Optional<LoginResponse> auth = userService.authenticateUser(credentials);

        if(!auth.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        session.setAttribute("user", auth.get());

        return ResponseEntity.ok(auth.get());

    }
}
