package com.projectgeneric.abstracts;

import com.projectgeneric.api.users.Usuario;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class AModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Usuario usuario;
}
