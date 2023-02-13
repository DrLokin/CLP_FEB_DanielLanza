package com.daniellanza.clpbackend.service;

import com.daniellanza.clpbackend.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
}
