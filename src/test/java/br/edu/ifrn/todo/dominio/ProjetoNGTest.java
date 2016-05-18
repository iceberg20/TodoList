/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author julia
 */
public class ProjetoNGTest {
    
    private Projeto projeto;
    private String nome1;
    private String nome2;
            
    @BeforeClass
    public void inicializacao(){
        nome1 = "Compras";
        nome2 = "Estudos";
        projeto = Projeto.builder().nome(nome1).build();
    }
    
    @Test
    public void nomesIguais() {
        assertThat(Projeto.builder().nome(nome1).build()).isEqualTo(projeto);
    }
    
    @Test
    public void nomesDiferentes() {
        assertThat(Projeto.builder().nome(nome2).build()).isNotEqualTo(projeto);
    }
   
    
}
