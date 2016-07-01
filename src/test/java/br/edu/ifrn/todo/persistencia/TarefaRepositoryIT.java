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

@SpringApplicationConfiguration(classes = TodoApplication.class)
@WebAppConfiguration
@Test(groups = "tarefa", dependsOnGroups = {"usuario"})
public class TarefaRepositoryIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private TarefaRepository tarefaRepository;
    
    @Inject
    private TarefaFactory tarefaFactory;
    
    @Inject
    private ProjetoFactory projetoFactory;
    
    @BeforeMethod
    void deletarTodos()
    {
        tarefaRepository.deleteAll();
        assertThat(tarefaRepository.findAll()).isEmpty();
    }
    
    public void repositorioNaoEhNulo () {
        assertThat(tarefaRepository).isNotNull();
    }
    
    public void deletarUm () {
        // cria o ambiente de teste
        Tarefa tarefa = tarefaFactory.tarefa();
        
        // executa a operacao a ser testada
        tarefaRepository.delete(tarefa);
        
        // verifica o efeito da execucao da operacao a ser testada
        assertThat(tarefaRepository.findOne(tarefa.getId())).isNull();
    }
    
    public void salvarUm () {
        // cria o ambiente de teste
        Tarefa tarefa =  (Tarefa)Atividade.builder()
                .nome("Testar salvar um")
                .prazo(tarefaFactory.retornaPrazo(2016, 10, 10))
                .projeto(projetoFactory.projeto())
                .build();
        
        // executa a operacao a ser testada
        tarefaRepository.save(tarefa);
        
        // verifica o efeito da execucao da operacao a ser testada
        assertThat(tarefaRepository.findAll().iterator().next()).isEqualTo(tarefa);
    }
}
