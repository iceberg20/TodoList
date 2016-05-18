/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.util.Calendar;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
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
    private Tarefa tarefa4; 
    private Tarefa tarefa5; 
    private String nome1;
    private String nome2;
    private Date prazo;
    
    @BeforeClass
    public void inicializacao(){
        nome1 = "Testar classes";
        nome2 = "Rodar testes";
        tarefa1 = new Tarefa();
        tarefa1.setNome(nome1);
        tarefa2 = new Tarefa();
        tarefa2.setNome(nome1);
        tarefa3 = new Tarefa();
        tarefa3.setNome(nome2);
        tarefa4 = new Tarefa();
        tarefa4.setNome(nome2);
        tarefa5 = new Tarefa();
        tarefa5.setNome(nome2);
        Calendar cal = Calendar.getInstance();
        cal.set(2016, 06, 01);
        prazo = cal.getTime();
        tarefa3.setPrazo(prazo);
        tarefa4.setPrazo(prazo);
    }
    
    @Test
    public void nomesIguaisSemPrazo() {
        assertThat(tarefa1).isEqualTo(tarefa2);
    }
    
    public void nomesPrazosIguais() {
        assertThat(tarefa3).isEqualTo(tarefa4);
    }
   
    @Test
    public void nomesIguaisComPrazosDiferentes() {
        assertThat(tarefa4).isNotEqualTo(tarefa5);
    }
    
    @Test
    public void nomesDiferentes(){
        assertThat(tarefa1.getNome()).isNotEqualTo(tarefa5); 
    }
    
}