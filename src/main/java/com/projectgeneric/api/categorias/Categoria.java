/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.categorias;

import com.projectgeneric.abstracts.AModel;
import com.projectgeneric.api.users.Usuario;
import java.io.Serializable;
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
public class Categoria extends AModel implements Serializable {

    String nome;
    String descricao;

    public Categoria() {
    }
}
