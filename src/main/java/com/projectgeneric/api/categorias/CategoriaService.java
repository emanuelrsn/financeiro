/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.categorias;

import com.projectgeneric.abstracts.AService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santana
 */
@Service
public class CategoriaService extends AService<CategoriaDTO, Categoria> {

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository,CategoriaDTO dto) {
        super(categoriaRepository, dto);
    }
}
