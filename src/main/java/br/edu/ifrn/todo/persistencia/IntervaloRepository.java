package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Intervalo;
import java.util.Iterator;
import org.springframework.data.repository.CrudRepository;

public interface IntervaloRepository extends CrudRepository <Intervalo, Long>{

}