package com.example.exampleSpringSecryti.persistence.repositories;

import com.example.exampleSpringSecryti.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorie extends JpaRepository<UsuarioEntity, Long> {

    public UsuarioEntity findByname(String name);
}
