package com.example.exampleSpringSecryti.persistence.repositories;

import com.example.exampleSpringSecryti.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorie extends JpaRepository<UsuarioEntity, Long> {

    public Optional<UsuarioEntity> findByname(String name);
    public Optional<UsuarioEntity> findByEmail(String email);
}
