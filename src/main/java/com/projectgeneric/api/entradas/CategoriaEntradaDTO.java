/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.entradas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.projectgeneric.abstracts.ADTO;
import com.projectgeneric.api.categorias.Categoria;
import com.projectgeneric.api.users.UsuarioDTO;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Santana
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Service
public class CategoriaEntradaDTO  {
    
    Integer id;
}
