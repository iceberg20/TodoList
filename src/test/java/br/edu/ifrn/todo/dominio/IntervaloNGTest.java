/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.time.LocalTime;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author julia
 */
public class IntervaloNGTest {
    
    private Intervalo int1;
    private LocalTime inicio1;
    private LocalTime inicio2;
    private LocalTime fim1;
    private LocalTime fim2;
    
    @BeforeClass
    public void inicializacao(){
        inicio1 = LocalTime.of(10, 10);
        inicio2 = LocalTime.of(10, 0);
        fim1 = LocalTime.of(12, 0);
        fim2 = LocalTime.of(12, 30);
        int1 = Intervalo.builder().horaInicio(inicio1).horaFim(fim1).build();
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
    
}
