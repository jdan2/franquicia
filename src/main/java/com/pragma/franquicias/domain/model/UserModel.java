package com.pragma.franquicias.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Long id;
    private String name;
    private String lastName;
    private String documentId;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String password;
}
