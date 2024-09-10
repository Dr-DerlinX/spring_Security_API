package com.example.exampleSpringSecryti.controllers;

import com.example.exampleSpringSecryti.persistence.entities.UsuarioEntity;
import com.example.exampleSpringSecryti.services.UsuarioServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class privateController {

    @Autowired
    private UsuarioServicesImpl services;

    @GetMapping("/userProfile")
    public ResponseEntity<UsuarioEntity> userProfile(@RequestHeader HttpHeaders headers){
        return ResponseEntity.ok(services.getLogingUser(headers));
    }

    @GetMapping("/example")
    public ResponseEntity<?> userExample(){
        return ResponseEntity.ok("Bienbenido usuario");
    }
}
