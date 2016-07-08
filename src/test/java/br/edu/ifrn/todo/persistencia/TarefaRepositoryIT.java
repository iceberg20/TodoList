
package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.TodoApplication;
import br.edu.ifrn.todo.dominio.Atividade;
import br.edu.ifrn.todo.dominio.Tarefa;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 * @author italo
 */
 @SpringApplicationConfiguration(classes = TodoApplication.class)
 @WebAppConfiguration
 @Test(groups = "Tarefa")
public class TarefaRepositoryIT extends AbstractTestNGSpringContextTests {
    
     @Inject
     private TarefaRepository tarefaRepository;
     
     
     @BeforeMethod
     void deletarTodos()
     {
         tarefaRepository.deleteAll();
         assertThat(tarefaRepository.findAll()).isEmpty();
     }
     
     public void repositorioNaoEhNulo () {
         assertThat(tarefaRepository).isNotNull();
     }
     
}
