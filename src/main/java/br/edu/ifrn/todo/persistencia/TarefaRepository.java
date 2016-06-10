package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Tarefa;
import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Long>{
    
}