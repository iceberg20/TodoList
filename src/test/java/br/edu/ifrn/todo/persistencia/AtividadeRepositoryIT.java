package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.TodoApplication;
import br.edu.ifrn.todo.dominio.Atividade;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = TodoApplication.class)
@WebAppConfiguration
@Test(groups = "atividade")
public class AtividadeRepositoryIT {
    @Inject
    private AtividadeRepository atividadeRepository;
    
    @Inject
    private AtividadeFactory atividadeFactory;
    
    @Inject
    private ProjetoFactory projetoFactory;
    
    @Inject
    private IntervaloFactory intervaloFactory;
    
    @BeforeMethod
    void deletarTodos()
    {
        atividadeRepository.deleteAll();
        assertThat(atividadeRepository.findAll()).isEmpty();
    }
    
    public void repositorioNaoEhNulo () {
        assertThat(atividadeRepository).isNotNull();
    }
    
    public void deletarUm () {
        // cria o ambiente de teste
        Atividade atividade = atividadeFactory.atividade();
        
        // executa a operacao a ser testada
        atividadeRepository.delete(atividade);
        
        // verifica o efeito da execucao da operacao a ser testada
        assertThat(atividadeRepository.findOne(atividade.getId())).isNull();
    }
    
    public void salvarUm () {
        // cria o ambiente de teste
        Atividade atividade = Atividade.builder()
                .nome("Testar salvar um")
                .prazo(atividadeFactory.retornaPrazo(2016, 10, 10))
                .projeto(projetoFactory.projeto())
                .intervalo(intervaloFactory.intervalo())
                .build();
        
        // executa a operacao a ser testada
        atividadeRepository.save(atividade);
        
        // verifica o efeito da execucao da operacao a ser testada
        assertThat(atividadeRepository.findAll().iterator().next()).isEqualTo(atividade);
    }
}
