/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.entradas;

import java.util.List;

import com.projectgeneric.abstracts.AJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Santana
 */
public  interface EntradaRepository extends AJpaRepository<Entrada, Integer> {
}
