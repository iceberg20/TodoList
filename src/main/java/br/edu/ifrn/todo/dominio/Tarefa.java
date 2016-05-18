/*
*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author italo
 */

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "date", "prioridade", "concluida"})
//@Data => Substitui os 4 acima, mas dá erro com getData
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@ToString

@Entity
@SequenceGenerator(sequenceName = "seq_tarefa", name = "ID_SEQUENCE", allocationSize = 1)
public class Tarefa implements Serializable {
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
   private Long id;
   
   @NonNull
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date prazo;
   
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date date;
   
   @NonNull
   private String nome;
   private int prioridade;
   private boolean concluida;   
   
   public Tarefa(Date prazo, Date date, String nome, int prioridade, boolean concluida){
       this.prazo = prazo;
       this.date = date;
       this.nome = nome;
       this.prioridade = prioridade;
       this.concluida = concluida;
   }

    Tarefa() {
    }
    
}
