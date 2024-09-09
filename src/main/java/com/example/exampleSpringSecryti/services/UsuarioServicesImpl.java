package com.example.exampleSpringSecryti.services;

import com.example.exampleSpringSecryti.persistence.entities.UsuarioEntity;
import com.example.exampleSpringSecryti.persistence.repositories.UsuarioRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@ComponentScan
public class UsuarioServicesImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorie repositorie;

    public void addNewUser(UsuarioEntity usuario) {
        repositorie.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
       UsuarioEntity usuario = repositorie.findByname(name);
       if (usuario == null){
           throw new UsernameNotFoundException("Usuario no encontrado");
       }
       else return new org.springframework.security.core.userdetails.User(usuario.getName(), usuario.getPassword(), new ArrayList<>());

    }
}
