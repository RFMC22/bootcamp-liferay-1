package com.jw.bootcamp.controller;

import java.util.List;

import com.jw.bootcamp.model.Usuario;
import com.jw.bootcamp.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AplicacionController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registro y Acceso
    
    @GetMapping("/")
    public String vistaInicio(){
        return "index";
    }

    @GetMapping("/registrar")
    public String vistaRegistro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registrar";
    }
   


    // CRUD
    @GetMapping("/listaUsuarios")
    public String vistaListaUsuarios(Model model){
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("listaUsuario", listaUsuario);
        return "usuarios";
    }

    @PostMapping("/procesarRegistro")
    public String procesarRegistro(Usuario usuario){
        BCryptPasswordEncoder encriptado = new BCryptPasswordEncoder();
        String passwordEncriptado = encriptado.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptado);
        usuarioRepository.save(usuario);
        return "registroExitoso";
    }

    @PostMapping("/guardar")
    public String guardar(@Validated Usuario usuario, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        usuarioRepository.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/eliminar")
    public String eliminar(Usuario usuario) {
        usuarioRepository.delete(usuario);
        return "redirect:/listaUsuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(Usuario usuario, Model model) {
        usuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        model.addAttribute("usuario", usuario);
        return "modificar";
    }
}
