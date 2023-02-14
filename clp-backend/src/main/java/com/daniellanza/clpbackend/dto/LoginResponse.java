package com.daniellanza.clpbackend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
}
