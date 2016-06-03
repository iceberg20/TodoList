package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Tarefa;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class TarefaRepositorioMemoria implements TarefaRepositorio {

    private Set<Tarefa> objetos = new TreeSet<>();
    
    @Override
    public void save(Tarefa objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Tarefa objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Tarefa> iterator() {
        return objetos.iterator();
    }
    
}