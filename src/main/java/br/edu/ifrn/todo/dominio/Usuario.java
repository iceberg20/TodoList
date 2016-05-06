/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author italo
 */

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private int nivel;
}
