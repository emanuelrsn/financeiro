/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.abstracts;


import com.projectgeneric.api.infra.exception.ObjectNotFoundException;
import com.projectgeneric.api.users.Usuario;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Santana
 * @param <T> 
 */
public abstract class AService<T extends ADTO, D extends AModel> {
    
    
    public final AJpaRepository jpaRepository;
    
    private final T t;
    public AService(AJpaRepository jpaRepository, T t){
        this.jpaRepository = jpaRepository;
        this.t =t;
    }
    
    public Object insert(T object){
        D d = (D)object.create();
        d.setUsuario(getUsuarioLogado());
        return object.create(this.jpaRepository.save(d));
    }

    public Object update(T object){
        getById(object.getId());
        D d = (D)object.create();
        d.setUsuario(getUsuarioLogado());
        return object.create(this.jpaRepository.save(d));
    }
    
    public boolean delete(Integer id) {
        this.jpaRepository.deleteById(id);
        return true;
    }

    public List<T> getByNome(String nome){
        return (List<T>) this.jpaRepository.findByNomeLikeIgnoreCaseAndUsuarioId("%"+nome+"%",
                getUsuarioLogado().getId()).stream().map(f ->this.t.create(f)).collect(Collectors.toList());
    }
    
    public T getById(Integer id) {
        try {
             return (T) this.t.create(this.jpaRepository.findById(id).
                orElseThrow(() -> new ObjectNotFoundException("Registro não encontrado.")));
        } catch (Throwable ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }
    
    public List<T> getAll() {
        return (List<T>) this.jpaRepository.findByUsuarioId(getUsuarioLogado().getId()).stream().map(f -> this.t.create(f)).collect(Collectors.toList());
    }

    public Usuario getUsuarioLogado() {
        
        if (SecurityContextHolder.getContext() != null) {
            Usuario usu = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        } else {
            return null;
        }
    }

}
