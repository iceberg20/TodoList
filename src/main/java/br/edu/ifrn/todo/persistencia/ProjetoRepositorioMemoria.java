package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Projeto;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class ProjetoRepositorioMemoria implements ProjetoRepositorio {

    private Set<Projeto> objetos = new TreeSet<>();
    
    @Override
    public void save(Projeto objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Projeto objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Projeto> iterator() {
        return objetos.iterator();
    }
    
}