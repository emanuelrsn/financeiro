/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.users;

import com.projectgeneric.api.infra.exception.GenericException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 *
 * @author Santana
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO insert(UsuarioDTO usuarioDto) {
        Assert.isNull(usuarioDto.getId(), "Não foi possível inserir o registro.");

        if (Objects.nonNull(usuarioRepository.findByLogin(usuarioDto.getLogin()))) {
            throw new GenericException("Já existe um usuário cadastrado com este e-mail.");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuarioDto.setSenha(encoder.encode(usuarioDto.getSenha()));
        Usuario usuario = UsuarioDTO.create(usuarioDto);

        UsuarioDTO usuarioreturn = new UsuarioDTO().create(usuarioRepository.save(usuario));
        usuarioreturn.setSenha(null);
        return usuarioreturn;

    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("1234"));
    }

    public UsuarioDTO update(Integer id, UsuarioDTO usuarioDto) {
        Assert.notNull(id, "Não foi possível atualizar o registro.");

        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            Usuario bd = optional.get();

            bd.setEmail(usuarioDto.getEmail());
            bd.setNome(usuarioDto.getNome());
            if (usuarioDto.getFoto() != null &&
                    !usuarioDto.getFoto().isEmpty()) {
                bd.setFoto(usuarioDto.getFoto());
                bd.setExtensao(usuarioDto.getExtensao());
                bd.setNome_foto(usuarioDto.getNome_foto());
            }

            if (Objects.nonNull(usuarioDto.getSenha())
                    && !usuarioDto.getSenha().trim().equals("")) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                usuarioDto.setSenha(encoder.encode(usuarioDto.getSenha()));
                bd.setSenha(usuarioDto.getSenha());
            }

            usuarioRepository.save(bd);
            bd.setSenha(null);
            return new UsuarioDTO().create(bd);

        } else {
            throw new GenericException("Usuário não encontrado.");
        }

    }

    public List<UsuarioDTO> getUsuarios() {

        return usuarioRepository.findAll().stream().map(f -> new UsuarioDTO().create(f)).collect(Collectors.toList());
    }
}
