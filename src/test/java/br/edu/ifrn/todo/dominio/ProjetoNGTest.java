/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author julia
 */
public class ProjetoNGTest {
    
    private Projeto projeto1;
    private Projeto projeto2;
    private String nome1;
    private String nome2;
            
    @BeforeClass
    public void inicializacao(){
        nome1 = "Compras";
        nome2 = "Estudos";
        projeto1 = Projeto.builder().nome(nome1).build();
        projeto2 = Projeto.builder().nome(nome2).build();
    }
    
    @Test
    public void nomesIguais() {
        assertThat(Projeto.builder().nome(nome1).build()).isEqualTo(projeto1);
    }
    
    @Test
    public void nomesDiferentes() {
        assertThat(Projeto.builder().nome(nome2).build()).isNotEqualTo(projeto1);
    }
   
    @Test
    public void compareTo() {
        Set<Projeto> projetos = new TreeSet<>();
        
        projetos.add(projeto2);
        projetos.add(projeto1);
        
        assertThat(projetos.iterator().next()).isEqualTo(projeto1);
    }
    
}
