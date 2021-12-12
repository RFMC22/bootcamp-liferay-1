package com.jw.bootcamp.service;

import java.util.List;

import com.jw.bootcamp.model.Usuario;
import com.jw.bootcamp.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);

    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuarioRepository.delete(usuario);

    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId()).orElse(null);
    }

}
