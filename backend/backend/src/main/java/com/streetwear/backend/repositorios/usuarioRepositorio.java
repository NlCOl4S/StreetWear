package com.streetwear.backend.repositorios;

import com.streetwear.backend.entidades.usuarios;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface usuarioRepositorio extends JpaRepository<usuarios, Long> {

}
