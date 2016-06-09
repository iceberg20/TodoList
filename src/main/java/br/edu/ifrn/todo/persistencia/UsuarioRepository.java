package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Usuario;
import java.util.Iterator;

public interface UsuarioRepositorio {

    void save(Usuario objeto);

    void delete(Usuario objeto);
    
    Iterator<Usuario> iterator();
    
}