/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@EqualsAndHashCode(callSuper = true, of = {"intervalo"})
@Entity
public class Atividade extends Tarefa{
    
    @OneToOne(mappedBy = "atividade")
    private Intervalo intervalo;
    
    @ManyToOne
    @JoinColumn(name = "projetoId", nullable = false, foreignKey = @ForeignKey(name = "fk_atividade_projeto"))
    private Projeto projeto;
  
    @Builder
    public Atividade(Long id, Date prazo, Date dataInicial, String nome, int prioridade, boolean concluida, Intervalo intervalo, Projeto projeto) {
        super(id, prazo, dataInicial, nome, prioridade, concluida);
        this.intervalo = intervalo;
        this.projeto = projeto;
    } 
    
}
