/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santana
 */
@RestController
    @RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getUsuarios());
    }

    @PostMapping
    public ResponseEntity post(@RequestBody UsuarioDTO usuario) {

       
        UsuarioDTO f = service.insert(usuario);

        return f != null ? ResponseEntity.ok(f) : ResponseEntity.badRequest().build();

    }
    
    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Integer id,@RequestBody UsuarioDTO usuario) {

       
        UsuarioDTO f = service.update(id, usuario);

        return f != null ? ResponseEntity.ok(f) : ResponseEntity.badRequest().build();

    }
}
