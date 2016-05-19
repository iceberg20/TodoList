/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.util.Date;
import javax.persistence.Entity;
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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Atividade extends Tarefa{
    
    private Intervalo intervalo;
    
    @Builder
    public Atividade(Long id, Date prazo, Date data, String nome, int prioridade, boolean concluida, Intervalo intervalo) {
        super(id, prazo, data, nome, prioridade, concluida);
        this.intervalo = intervalo;
    }
    
}
