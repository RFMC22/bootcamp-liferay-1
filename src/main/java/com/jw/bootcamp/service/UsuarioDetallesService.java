package com.jw.bootcamp.service;

import com.jw.bootcamp.model.Usuario;
import com.jw.bootcamp.repository.UsuarioRepository;
import com.jw.bootcamp.util.UsuarioDetalles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioDetallesService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(correo);

        if (usuario == null) {
            throw new UsernameNotFoundException("El usuario no a sido encontrado o no existe");
        }
        return new UsuarioDetalles(usuario);
    }


}
