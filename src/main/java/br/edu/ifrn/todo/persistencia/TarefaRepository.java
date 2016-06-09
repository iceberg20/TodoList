package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Tarefa;
import java.util.Iterator;

public interface TarefaRepository {

    void save(Tarefa objeto);

    void delete(Tarefa objeto);
    
    Iterator<Tarefa> iterator();
    
}
