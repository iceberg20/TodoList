package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Intervalo;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class IntervaloRepositorioMemoria implements IntervaloRepositorio {

    private Set<Intervalo> objetos = new TreeSet<>();
    
    @Override
    public void save(Intervalo objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Intervalo objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Intervalo> iterator() {
        return objetos.iterator();
    }
    
}