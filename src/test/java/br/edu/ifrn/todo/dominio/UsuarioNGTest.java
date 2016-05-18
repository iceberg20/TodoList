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
public class UsuarioNGTest {
    
    private Usuario usuario;
    private String email1;
    private String email2;
    private String nome1;
    private String nome2;
    private String senha1;
    private String senha2;
    private int numero1;
    private int numero2;
            
    @BeforeClass
    public void inicializacao(){
        
        nome1 = "Luan";
        nome2 = "Luana";
        email1 = "euvou@todo.com";
        email2 = "tads@todo.com";
        senha1 = "luan";
        senha2 = "luana";
        numero1 = 1;
        numero2 = 2;
        usuario = Usuario.builder().email(email1).nivel(numero1).nome(nome1)
                .qtdTarefa(numero1).senha(senha1).combo(numero1).build();
        
    }
    
    @Test
    public void emailsIguais() {
        assertThat(Usuario.builder().email(email1).build()).isEqualTo(usuario);
    }
    
    @Test
    public void emailsDiferentes() {
        assertThat(Usuario.builder().email(email2).build()).isNotEqualTo(usuario);
    }
    
    @Test
    public void emailsIguaisRestoDiferente() {
        assertThat(Usuario.builder().email(email1).nivel(numero2).nome(nome2).qtdTarefa(numero2)
                .senha(senha2).combo(numero2).build()).isEqualTo(usuario);
    }
}