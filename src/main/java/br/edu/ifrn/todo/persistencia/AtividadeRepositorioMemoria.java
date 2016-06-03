package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Atividade;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class AtividadeRepositorioMemoria implements AtividadeRepositorio {

    private Set<Atividade> objetos = new TreeSet<>();
    
    @Override
    public void save(Atividade objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Atividade objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Atividade> iterator() {
        return objetos.iterator();
    }
    
}