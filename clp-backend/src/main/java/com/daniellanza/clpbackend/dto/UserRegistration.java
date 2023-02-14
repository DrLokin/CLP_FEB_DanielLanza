package com.daniellanza.clpbackend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserRegistration {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

}
