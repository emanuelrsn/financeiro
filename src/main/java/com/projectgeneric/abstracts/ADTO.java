/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.abstracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectgeneric.api.users.UsuarioDTO;
import com.projectgeneric.interfaces.IDTO;
import java.lang.reflect.ParameterizedType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Santana
 * @param <T>
 * @param <D>
 */
public abstract class ADTO<T, D> implements IDTO<T, D> {

    @ApiModelProperty(position = 1, required = false, hidden=true)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @Override
    public T create() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public D create(T o) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(o, (Class<D>) this.getClass());

    }
    
    @Override
    public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }

}
