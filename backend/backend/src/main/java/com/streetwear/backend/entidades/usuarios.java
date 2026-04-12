package com.streetwear.backend.entidades;
import lombok.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class usuarios  {
    @Id
    private Long cedula;
    private String nombre;
    private int edad;
    private String apellidos;
    private String direccion;

}
