package com.example.exampleSpringSecryti.services;

import com.example.exampleSpringSecryti.persistence.entities.UsuarioEntity;
import com.example.exampleSpringSecryti.persistence.repositories.UsuarioRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@ComponentScan
public class UsuarioServicesImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorie repositorie;

    public String addNewUser(UsuarioEntity usuario) {

        Optional<UsuarioEntity> existingUser = repositorie.findByname(usuario.getName());
        Optional<UsuarioEntity> existingEmail = repositorie.findByEmail(usuario.getEmail());

        if (existingUser.isPresent())  return "Usuario ya registrado, intenta con un nuevo usuario";
        if (existingEmail.isPresent())  return "Correo ya registrado, intenta con un nuevo correo";

        return " " + repositorie.save(usuario);

    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UsuarioEntity> usuario = repositorie.findByname(name);
       if (usuario.isEmpty()){
           throw new UsernameNotFoundException("Usuario no encontrado");
       }
       UsuarioEntity usuarioEntity = usuario.get();

       return new User(usuarioEntity.getName(), usuarioEntity.getPassword(), new ArrayList<>());

    }

    public UsuarioEntity getLogingUser(HttpHeaders headers) throws UsernameNotFoundException{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String name = ((User) authentication.getPrincipal()).getUsername();

        Optional<UsuarioEntity> optionalUsuario = repositorie.findByname(name);

        if (optionalUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return optionalUsuario.get();
    }
}
