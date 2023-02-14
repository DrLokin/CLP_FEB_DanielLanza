package com.daniellanza.clpbackend.data;

import lombok.*;

import javax.persistence.*;

@Data
@Entity(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(unique = true)
    private String username;


    private String password;


    private String email;


    private String firstName;


    private String lastName;

}
