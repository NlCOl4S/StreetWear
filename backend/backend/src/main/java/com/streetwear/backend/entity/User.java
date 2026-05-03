package com.streetwear.backend.entity;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    @Id
    private Long cedula;
    private String nombre;
    private int edad;
    private String apellidos;
    private String direccion;

}
