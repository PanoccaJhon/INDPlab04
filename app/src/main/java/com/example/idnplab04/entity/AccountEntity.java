package com.example.idnplab04.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEntity {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String phone;

}
