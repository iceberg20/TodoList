package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Projeto;

public interface ProjetoRepositoryCustom {
    int tarefasAbertas(Projeto projeto);
    int tarefasFechadas(Projeto projeto);
}
