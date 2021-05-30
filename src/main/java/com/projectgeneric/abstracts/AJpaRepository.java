package com.projectgeneric.abstracts;

import com.projectgeneric.api.categorias.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
@NoRepositoryBean
public interface AJpaRepository<T extends AModel, ID extends Serializable>
        extends JpaRepository<T, ID> {
    public List<T> findByUsuarioId(Integer usuarioId);
    public List<T> findByNomeLikeIgnoreCaseAndUsuarioId(String nome, Integer usuarioId);
}
