/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.TodoApplication;
import br.edu.ifrn.todo.dominio.Usuario;
import br.edu.ifrn.todo.persistencia.UsuarioRepository;
 import javax.inject.Inject;
 import org.springframework.boot.test.SpringApplicationConfiguration;
 import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
 import org.springframework.test.context.web.WebAppConfiguration;
 import org.testng.annotations.Test;
 import org.testng.annotations.BeforeMethod;
 import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author italo
 */

 @SpringApplicationConfiguration(classes = TodoApplication.class)
 @WebAppConfiguration
 @Test(groups = "Usuario")
public class UsuarioRepositoryIT extends AbstractTestNGSpringContextTests {
     @Inject
     private UsuarioRepository usuarioRepository;
     
     @BeforeMethod
     void deletarTodos()
     {
         usuarioRepository.deleteAll();
         assertThat(usuarioRepository.findAll()).isEmpty();
     }
     
     public void repositorioNaoEhNulo () {
         assertThat(usuarioRepository).isNotNull();
     }
     
      public void deletarUm () {
         // cria o ambiente de teste
         Usuario usuario = Usuario.builder().nome("maria").build();
         
         // executa a operacao a ser testada
         usuarioRepository.delete(usuario);
         
         // verifica o efeito da execucao da operacao a ser testada
         assertThat(usuarioRepository.findOne(usuario.getId())).isNull();
     }
      
     public void salvarUm () {
          // cria o ambiente de teste
          Usuario usuario = Usuario.builder().nome("maria").build();
           
           // executa a operacao a ser testada
           usuarioRepository.save(usuario);
           
           // verifica o efeito da execucao da operacao a ser testada
           assertThat(usuarioRepository.findAll().iterator().next()).isEqualTo(usuario);
       }
     
     public void encontrarUsuarioPorEmail(){
         Usuario usuario = Usuario.builder()
                 .nome("maria")
                 .email("maria@gmail.com")
                 .build();
         
         usuarioRepository.save(usuario);
         
         Usuario usuarioEncontrado =  usuarioRepository.findByEmail("maria@gmail.com");
         
         assertThat(usuarioEncontrado.email()).isEqualTo("maria@gmail.com");
         
     }
    
}
