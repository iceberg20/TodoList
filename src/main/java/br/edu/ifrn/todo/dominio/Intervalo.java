/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author italo
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Builder
@ToString

@Entity
@SequenceGenerator(sequenceName = "seq_intervalo", name = "ID_SEQUENCE", allocationSize = 1)

public class Intervalo implements Serializable, Comparable<Intervalo> {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;
    
    @OneToOne 
    @JoinColumn(name="atividadeId", insertable=false, updatable=false, nullable = false, foreignKey = @ForeignKey(name = "fk_intervalo_atividade")) 
    private Atividade atividade;
  
    private LocalTime horaInicio;
    private LocalTime horaFim;

    @Override
    public int compareTo(Intervalo o) {
        int result = horaInicio.compareTo(o.horaInicio);
        if (result ==0)
        {
            result = horaFim.compareTo(o.horaFim);
        }
        return result;
    }
    
    public void verificarAtributos() {
        if (horaInicio.equals(horaFim)) {
            throw new IllegalArgumentException("O fim do intervalo não pode ser igual ao início: " + horaFim);
        }
        if (horaFim.isAfter(horaInicio)) {
            throw new IllegalArgumentException("O fim do intervalo não pode ser anterior ao inicio: " + horaFim);     
        }    
    }
    
}
