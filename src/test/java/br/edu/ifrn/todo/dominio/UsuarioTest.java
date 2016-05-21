/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.util.Set;
import java.util.TreeSet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author julia
 */
public class UsuarioTest {
    
    private Usuario usuario1;
    private Usuario usuario2;
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
        email1 = "tads@todo.com";
        email2 = "euvou@todo.com";
        senha1 = "luan";
        senha2 = "luana";
        numero1 = 1;
        numero2 = 2;
        usuario1 = Usuario.builder().email(email1).nivel(numero1).nome(nome1)
                .senha(senha1).combo(numero1).build();
        usuario2 = Usuario.builder().email(email2).build();
        
    }
    
    @Test
    public void emailsIguais() {
        assertThat(Usuario.builder().email(email1).build()).isEqualTo(usuario1);
    }
    
    @Test
    public void emailsDiferentes() {
        assertThat(Usuario.builder().email(email2).build()).isNotEqualTo(usuario1);
    }
    
    @Test
    public void emailsIguaisRestoDiferente() {
        assertThat(Usuario.builder().email(email1).nivel(numero2).nome(nome2)
                .senha(senha2).combo(numero2).build()).isEqualTo(usuario1);
    }
    
    @Test
    public void compareTo() {
        Set<Usuario> usuarios = new TreeSet<>();
        
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        
        assertThat(usuarios.iterator().next()).isEqualTo(usuario2);
    }
}