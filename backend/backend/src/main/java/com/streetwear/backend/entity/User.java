package com.streetwear.backend.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cedula;

    private String nombre;

    @NotNull
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    private String apellidos;
    private String direccion;

}
