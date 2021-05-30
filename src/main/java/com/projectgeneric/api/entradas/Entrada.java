/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.entradas;

import com.projectgeneric.abstracts.AModel;
import com.projectgeneric.api.categorias.Categoria;
import com.projectgeneric.api.users.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Santana
 */
@Entity
@Data
@AllArgsConstructor
public class Entrada extends AModel implements Serializable {


    String nome;
    String descricao;
    String tipo;
    BigDecimal valor;
    String datamovimentacao;
    Boolean pago;
    @OneToOne
    Categoria categoria;
    @OneToOne
    Usuario usuario;

    public Entrada() {

    }
}
