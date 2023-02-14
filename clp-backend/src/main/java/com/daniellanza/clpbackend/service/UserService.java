package com.daniellanza.clpbackend.service;

import com.daniellanza.clpbackend.data.User;
import com.daniellanza.clpbackend.dto.UserRegistration;
import com.daniellanza.clpbackend.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public User saveUser(UserRegistration userRegistration){
        User user = objectMapper.convertValue(userRegistration,User.class);
        return userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).get();
    }

}
