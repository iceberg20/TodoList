package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Projeto;
import br.edu.ifrn.todo.dominio.Usuario;

public interface ProjetoRepositoryCustom {
    int tarefasAbertas(Projeto projeto);
    int tarefasFechadas(Projeto projeto);
}
