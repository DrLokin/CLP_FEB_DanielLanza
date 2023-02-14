package com.daniellanza.clpbackend.service;

import com.daniellanza.clpbackend.data.User;
import com.daniellanza.clpbackend.dto.LoginRequest;
import com.daniellanza.clpbackend.dto.LoginResponse;
import com.daniellanza.clpbackend.dto.UserRegistration;
import com.daniellanza.clpbackend.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<LoginResponse> authenticateUser(LoginRequest authRequest){
        User user = userRepository.findByUsername(authRequest.getUsername());
        Optional<LoginResponse> logIn;

        if(user.getPassword() == authRequest.getPassword()){
            logIn = Optional.of(UserService.generateLoginResponse(user));
        }else{
            logIn = Optional.empty();
        }

        return logIn;
    }

    private static LoginResponse generateLoginResponse(User user){
        LoginResponse logIn = new LoginResponse();
        logIn.setId(user.getId());
        logIn.setEmail(user.getEmail());
        logIn.setFirstName(user.getFirstName());
        logIn.setLastName(user.getLastName());
        return logIn;
    }

}
