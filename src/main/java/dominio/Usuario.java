/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author italo
 */

@Getter
@Setter
@Builder
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private int nivel;
}
