package com.daniellanza.clpbackend.controller;

import com.daniellanza.clpbackend.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequiredArgsConstructor
public class UserController {

    private UserService userService;
}
