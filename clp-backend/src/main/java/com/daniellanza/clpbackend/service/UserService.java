package com.daniellanza.clpbackend.service;

import com.daniellanza.clpbackend.data.User;
import com.daniellanza.clpbackend.dto.LoginRequest;
import com.daniellanza.clpbackend.dto.LoginResponse;
import com.daniellanza.clpbackend.dto.UserRegistration;
import com.daniellanza.clpbackend.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(UserRegistration userRegistration){
        User user = new User();
        System.out.println(user==null);
        user.setEmail(userRegistration.getEmail());
        user.setPassword(userRegistration.getPassword());
        user.setUsername(userRegistration.getUsername());
        user.setFirstName(userRegistration.getFirstName());
        user.setLastName(userRegistration.getLastName());
        System.out.println(user.getEmail());
        return userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).get();
    }

    public Optional<LoginResponse> authenticateUser(LoginRequest authRequest){
        User user = userRepository.findByUsername(authRequest.getUsername());
        Optional<LoginResponse> logIn;

        if(Objects.equals(user.getPassword(), authRequest.getPassword())){
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
