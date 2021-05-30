/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.entradas;

import com.projectgeneric.abstracts.ADTO;
import com.projectgeneric.api.categorias.CategoriaDTO;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Santana
 */
@Data
@Service
public class EntradaDTO extends ADTO<Entrada, EntradaDTO>{
    @NotNull(message = "O nome é obrigatório.")
    String nome;
    @NotNull(message = "A descrição é obrigatório.")
    String descricao;
    @NotNull(message = "O tipo é obrigatório.")
    String tipo;
    @NotNull(message = "O valor é obrigatório.")
    BigDecimal valor;
    @NotNull(message = "A data da movimentação é obrigatório.")
    String datamovimentacao;
    @NotNull(message = "O campo pago é obrigatório.")
    Boolean pago;
    CategoriaEntradaDTO categoria;
}
