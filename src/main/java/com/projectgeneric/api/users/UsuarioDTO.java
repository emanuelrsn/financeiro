/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectgeneric.abstracts.ADTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Santana
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO extends ADTO<Usuario, UsuarioDTO> {
    private String login;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private String extensao;
    private String nome_foto;
    
    // token jwt
    private String token;
    
    public static UsuarioDTO create(Usuario usuario, String token) {
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO dto =modelMapper.map(usuario, UsuarioDTO.class);
        dto.token = token;
        return dto;
    }

    public static Usuario create(UsuarioDTO usuario){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, Usuario.class);
    }

    public String toJson() throws JsonProcessingException{
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }
}
