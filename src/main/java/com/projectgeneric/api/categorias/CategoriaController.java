/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.categorias;

import com.projectgeneric.api.users.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * @author Santana
 */
@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController{

    @Autowired
    CategoriaService service;
    
    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        boolean ok = service.delete(id);
        return ok ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.badRequest().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return  ResponseEntity.ok(service.getById(id));
    }
    
    @GetMapping("/getByNome/{nome}")
    public ResponseEntity getByNome(@PathVariable String nome) {
        return  ResponseEntity.ok(service.getByNome(nome));
    }
    
    @PostMapping
    public ResponseEntity insert(@RequestBody @Valid CategoriaDTO categoria) {
        return  ResponseEntity.ok(service.insert(categoria));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid CategoriaDTO categoria) {
        categoria.setId(id);
        return  ResponseEntity.ok(service.update(categoria));
    }
}