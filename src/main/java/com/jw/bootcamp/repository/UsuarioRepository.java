package com.jw.bootcamp.repository;

import com.jw.bootcamp.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    @Query("SELECT u FROM Usuario u WHERE u.correo = ?1")
    Usuario findByEmail(String correo);
}
