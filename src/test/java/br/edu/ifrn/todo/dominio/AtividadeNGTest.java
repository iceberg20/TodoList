/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author julia
 */
public class AtividadeNGTest {
    
    private Atividade atividade1; 
    private String nome1;
    private String nome2;
    private Date prazo1;
    private Date prazo2;
    private Intervalo intervalo1;
    private Intervalo intervalo2;
    private LocalTime inicio;
    private LocalTime fim1;
    private LocalTime fim2;
            
    @BeforeClass
    public void inicializacao(){
        Calendar cal = Calendar.getInstance();
        cal.set(2016, 06, 01);
        prazo1 = cal.getTime();
        
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2016, 06, 02);
        prazo2 = cal2.getTime();
        
        nome1 = "Testar classes";
        nome2 = "Rodar testes";
        
        inicio = LocalTime.of(10, 00);
        fim1 = LocalTime.of(12, 0);
        fim2 = LocalTime.of(12, 10);
        
        intervalo1 = Intervalo.builder().horaInicio(inicio).horaFim(fim1).build();
        intervalo2 = Intervalo.builder().horaInicio(inicio).horaFim(fim2).build();
        
        atividade1 = Atividade.builder().nome(nome1).prazo(prazo1).intervalo(intervalo1).build();
        
    }
    
    @Test
    public void nomesPrazosIntervalosIguais() {
        assertThat(Atividade.builder().nome(nome1).prazo(prazo1).intervalo
        (intervalo1).build()).isEqualTo(atividade1);
    }
    
    @Test
    public void nomesPrazosIguaisIntervalosDiferentes() {
        assertThat(Atividade.builder().nome(nome1).prazo(prazo1).intervalo
        (intervalo2).build()).isNotEqualTo(atividade1);
    }
    
    @Test
    public void nomesIguaisPrazosIntervalosDiferentes() {
        assertThat(Atividade.builder().nome(nome1).prazo(prazo2).intervalo
        (intervalo2).build()).isNotEqualTo(atividade1);
    }
   
    @Test
    public void nomesDiferentesPrazosIntervalosIguais() {
        assertThat(Atividade.builder().nome(nome2).prazo(prazo1).intervalo
        (intervalo1).build()).isNotEqualTo(atividade1);
    }

    
}
