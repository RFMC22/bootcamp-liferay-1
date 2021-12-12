package com.jw.bootcamp;

import static org.assertj.core.api.Assertions.assertThat;

import com.jw.bootcamp.model.Usuario;
import com.jw.bootcamp.repository.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCrearUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("boot");
        usuario.setApellido("camp");
        usuario.setCorreo("bootcamp@mail.com");
        usuario.setPassword("123abc");

        Usuario guardarUsuario = usuarioRepository.save(usuario);

        Usuario existeUsuario = entityManager.find(Usuario.class, guardarUsuario.getId());

        assertThat(existeUsuario.getCorreo()).isEqualTo(usuario.getCorreo());

    }

    @Test
    public void testBusquedaPorCorreo(){
        String correo = "rmagall@mail.com";

        Usuario usuario = usuarioRepository.findByEmail(correo);

        assertThat(usuario).isNotNull();
    }
}
