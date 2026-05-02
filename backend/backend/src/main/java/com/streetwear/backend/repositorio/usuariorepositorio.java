package com.streetwear.backend.repositorio;

import com.streetwear.backend.entidad.usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface usuariorepositorio extends JpaRepository<usuario, Long> {

}
