package com.streetwear.backend.entidad;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class usuario {
    @Id
    private Long cedula;
    private String nombre;
    private int edad;
    private String apellidos;
    private String direccion;

}
