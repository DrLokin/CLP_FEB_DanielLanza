package com.daniellanza.clpbackend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginRequest {
    private String username;
    private String password;
}
