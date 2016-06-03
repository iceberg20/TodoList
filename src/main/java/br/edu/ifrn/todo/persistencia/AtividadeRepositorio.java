package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Atividade;
import java.util.Iterator;

public interface AtividadeRepositorio {

    void save(Atividade objeto);

    void delete(Atividade objeto);
    
    Iterator<Atividade> iterator();
    
}