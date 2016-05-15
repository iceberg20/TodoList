/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.util.Calendar;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author julia
 */
public class TarefaNGTest {
    
    private Tarefa tarefa1; 
    private Tarefa tarefa2; 
    private Tarefa tarefa3; 
    private String nome1;
    private String nome2;
    private Date prazo;
    
    @BeforeClass
    public void inicializacao(){
        nome1 = "Testar classes";
        nome2 = "Rodar testes";
        tarefa1 = Tarefa.builder().nome(nome1).build(); 
        tarefa2 = Tarefa.builder().nome(nome2).build();
        tarefa3 = Tarefa.builder().nome(nome1).build();
        Calendar cal = Calendar.getInstance();
        cal.set(2016, 06, 01);
        prazo = cal.getTime();
        tarefa3.setPrazo(prazo);
    }
    
    @Test
    public void nomesIguaisSemPrazo() {
        assertThat(Tarefa.builder().nome(nome1).build()).isEqualTo(tarefa1);
    }
    
   
    @Test
    public void nomesIguaisComPrazosDiferentes() {
        assertThat(tarefa1).isNotEqualTo(tarefa3);
    }
    
    @Test
    public void nomesDiferentes(){
        assertThat(tarefa1.getNome()).isNotEqualTo(tarefa2); 
    }
    
}
