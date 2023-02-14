package com.daniellanza.clpbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegistration {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

}
