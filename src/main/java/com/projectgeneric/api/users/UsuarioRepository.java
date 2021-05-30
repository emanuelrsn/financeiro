/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.users;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Santana
 */
public  interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
    
}
