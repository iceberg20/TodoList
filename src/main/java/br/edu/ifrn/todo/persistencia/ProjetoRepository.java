package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Projeto;
import java.util.Iterator;

public interface ProjetoRepository {

    void save(Projeto objeto);

    void delete(Projeto objeto);
    
    Iterator<Projeto> iterator();
    
}