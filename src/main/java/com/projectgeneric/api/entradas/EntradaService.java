/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.entradas;

import com.projectgeneric.abstracts.AService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santana
 */
@Service
public class EntradaService  extends AService<EntradaDTO, Entrada>{


    public EntradaService(EntradaRepository entradaRepository, EntradaDTO t) {
        super(entradaRepository, t);
    }

}
