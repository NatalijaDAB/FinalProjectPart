package com.example.demo;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RegistrationRequest{//Dto
    private final String username;
    private final String email;
    private final String password;

}
