package br.edu.ifrn.todo.servico;

import br.edu.ifrn.todo.TodoApplication;
import br.edu.ifrn.todo.dominio.Projeto;
import br.edu.ifrn.todo.dominio.Usuario;
import static br.edu.ifrn.todo.persistencia.UsuarioFactory.USUARIO;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



@SpringApplicationConfiguration(classes = TodoApplication.class)
@WebAppConfiguration
@Test(groups = "projeto")
public class ProjetoServicoIT extends AbstractTestNGSpringContextTests {

    @Inject
    private ProjetoServico projetoServico;
    
    @Inject
    private UsuarioServico usuarioServico;
    
    @BeforeMethod
    void deletarTodos()
    {
        projetoServico.deleteAll();
        usuarioServico.deleteAll();
        assertThat(projetoServico.findAll()).isEmpty();
        assertThat(usuarioServico.findAll()).isEmpty();
    }
    
    private Usuario usuario(){
        Usuario usuario = usuarioServico.findByEmail("todo@todo.com");
        
        if (usuario == null){
            usuario = Usuario.builder()
                .email("todo@todo.com")
                .nome("Todo")
                .build();
        }
        return usuario;
    }
    
    public void repositorioNaoEhNulo () {
        assertThat(projetoServico).isNotNull();
    }
    
    public void salvarUm () {
        // cria o ambiente de teste
        Projeto projeto = Projeto.builder()
                .nome("Testes")
                .usuario(usuario())
                .build();
        
        // executa a operacao a ser testada
        projetoServico.save(projeto);
        
        // verifica o efeito da execucao da operacao a ser testada
        assertThat(projetoServico.findAll().iterator().next()).isEqualTo(projeto);
    }
    
    public void deletarUm () {
        // cria o ambiente de teste
        Projeto projeto = Projeto.builder()
                .nome("Testes2")
                .usuario(usuario())
                .build();
        projetoServico.save(projeto);
        
        // executa a operacao a ser testada
        projetoServico.delete(projeto);
        
        // verifica o efeito da execucao da operacao a ser testada
        assertThat(projetoServico.findAll().iterator().hasNext()).isFalse();
    }
    
}
   
