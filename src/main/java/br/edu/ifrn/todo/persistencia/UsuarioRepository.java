package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Usuario;
import java.util.Iterator;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByEmail(String email);
    
}