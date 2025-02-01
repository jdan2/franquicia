package com.pragma.franquicias.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name= "nombre",length = 50)
    private String name;

    @Column(name= "apellido", length = 50)
    private String lastName;

    @Column(name= "numero_documento",length = 50)
    private String documentId;

    @Column(name= "celular", length = 50)
    private String phone;

    @Column(name= "fecha_nacimiento")
    private Date birthDate;

    @Column(name= "correo", length = 50)
    private String email;

    @Column(name= "clave", length = 50)
    private String password;


}
