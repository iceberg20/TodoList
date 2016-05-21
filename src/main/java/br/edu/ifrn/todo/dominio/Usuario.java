/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author italo
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "nivel", "combo", "nome", "senha", "qtdTarefa"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_usuario", name = "ID_SEQUENCE", allocationSize = 1)
public class Usuario implements Serializable, Comparable<Usuario>{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;
    
    @OneToMany(mappedBy = "usuario")
    private Set<Projeto> projetos;

    private String nome;
    private String email;
    private String senha;
    private int nivel;
    private int combo;
    private int qtdTarefa;
    
    @Override
    public int compareTo(Usuario o) {
        return email.compareTo(o.email);
    }
}
