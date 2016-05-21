/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author julia
 */
public class IntervaloTest {
    
    private Intervalo int1;
    private Intervalo int2;
    private LocalTime inicio1;
    private LocalTime inicio2;
    private LocalTime fim1;
    private LocalTime fim2;
    
    @BeforeClass
    public void inicializacao(){
        inicio1 = LocalTime.of(10, 10);
        inicio2 = LocalTime.of(9, 9);
        fim1 = LocalTime.of(12, 0);
        fim2 = LocalTime.of(11, 0);
        int1 = Intervalo.builder().horaInicio(inicio1).horaFim(fim1).build();
        int2 = Intervalo.builder().horaInicio(inicio2).horaFim(fim2).build();
    }
    
    @Test
    public void inicioFimIguais() {
        assertThat(Intervalo.builder().horaInicio(inicio1).horaFim(fim1).build())
                .isEqualTo(int1);
    }
    
    @Test
    public void inicioIgualFimDiferente() {
        assertThat(Intervalo.builder().horaInicio(inicio1).horaFim(fim2).build())
                .isNotEqualTo(int1);
    }
    
    @Test
    public void inicioDiferenteFimIgual() {
        assertThat(Intervalo.builder().horaInicio(inicio2).horaFim(fim1).build())
                .isNotEqualTo(int1);
    }
    
    @Test
    public void inicioFimDiferentes() {
        assertThat(Intervalo.builder().horaInicio(inicio2).horaFim(fim2).build())
                .isNotEqualTo(int1);
    }
    
    @Test
    public void compareTo() {
        Set<Intervalo> intervalos = new TreeSet<>();
        
        intervalos.add(int1);
        intervalos.add(int2);
        
        assertThat(intervalos.iterator().next()).isEqualTo(int2);
    }
    
}
