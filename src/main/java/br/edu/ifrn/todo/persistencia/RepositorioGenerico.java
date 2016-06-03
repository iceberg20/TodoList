/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.todo.persistencia;

import java.util.Iterator;

/**
 *
 * @author italo
 */
public interface RepositorioGenerico<T> {
    void save(T objeto);
    void delete(T objeto);    
    Iterator<T> iterator();    
}
