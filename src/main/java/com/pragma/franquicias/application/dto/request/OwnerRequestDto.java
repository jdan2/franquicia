package com.pragma.franquicias.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OwnerRequestDto {

    private String name;
    private String lastName;
    private String documentId;
    private String phone;
    private Date birthDate;
    private String email;
    private String password;

}
