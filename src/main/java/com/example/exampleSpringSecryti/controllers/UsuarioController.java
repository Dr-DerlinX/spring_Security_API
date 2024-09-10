package com.example.exampleSpringSecryti.controllers;

import com.example.exampleSpringSecryti.config.JwtFilter;
import com.example.exampleSpringSecryti.dot.AuthRequest;
import com.example.exampleSpringSecryti.persistence.entities.UsuarioEntity;
import com.example.exampleSpringSecryti.services.UsuarioServicesImpl;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private UsuarioServicesImpl services;

    @Autowired
    private JwtFilter jwtFilter;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public UsuarioController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
     public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest credentials){
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        String token = jwtFilter.generateToken(credentials);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        System.out.println(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<String> addNewUser(@RequestBody UsuarioEntity usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        services.addNewUser(usuario);
        return ResponseEntity.ok("Usuario guardado correctamente");
    }

}
