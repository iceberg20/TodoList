package br.edu.ifrn.todo.persistencia;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class RepositorioMemoriaGenerico<T> implements RepositorioGenerico<T> {

    private Set<T> objetos = new TreeSet<>();
    
    @Override
    public void save(T objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(T objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<T> iterator() {
        return objetos.iterator();
    }
    
}