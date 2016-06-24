package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Usuario;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UsuarioFactory {
    public final static String USUARIO = "Usuario01";
    public final static String EMAIL = "user@todo.com";
    
    @Inject
    private UsuarioRepository usuarioRepository;
    
    public Usuario usuario() {
        Usuario usuario = Usuario.builder()
                .email(EMAIL)
                .nome(USUARIO)
                .build();
        usuarioRepository.save(usuario);
        return usuario;
    }
    
    public Usuario usuario(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
