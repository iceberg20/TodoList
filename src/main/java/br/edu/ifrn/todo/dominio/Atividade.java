/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.dominio;

import java.util.Date;

/**
 *
 * @author italo
 */
public class Atividade extends Tarefa{
    
    public Atividade(Date prazo, Date data, String nome, int prioridade, boolean concluida) {
        super(prazo, data, nome, prioridade, concluida);
    }
    
}
