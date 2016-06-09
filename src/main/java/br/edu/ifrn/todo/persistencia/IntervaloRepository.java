package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Intervalo;
import java.util.Iterator;

public interface IntervaloRepository {

    void save(Intervalo objeto);

    void delete(Intervalo objeto);
    
    Iterator<Intervalo> iterator();
    
}