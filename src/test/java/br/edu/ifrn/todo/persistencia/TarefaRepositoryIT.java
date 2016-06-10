/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.TodoApplication;
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
     
     public void findOneByExample () {
         // cria o ambiente de teste
         Tarefa tarefa = new Tarefa("Estudar");
 
         ContaCredito tarefaExemplo = ContaCredito.builder()
             .categoria(Categoria.builder().descricao(FabricaDominio.SALARIO).build())
             .build();
                        
         // executa a operacao a ser testada
         // verifica o efeito da execucao da operacao a ser testada
         assertThat(tarefaRepository.findOne(Example.of(tarefaExemplo)))
             .isEqualTo(tarefa);
     }
}
