package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Projeto;
import br.edu.ifrn.todo.dominio.QAtividade;
import br.edu.ifrn.todo.dominio.QTarefa;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ProjetoRepositoryImpl implements ProjetoRepositoryCustom {

    private final EntityManager entityManager;
    
    @Inject
    public ProjetoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public int tarefasAbertas(Projeto projeto) {
        
        QTarefa qTarefa = QTarefa.tarefa;
        QAtividade qAtividade = QAtividade.atividade;
        
        JPQLQueryFactory factory = new JPAQueryFactory(entityManager);
        
        Long totalTarefas = factory
            .from(qTarefa)
            .where(qTarefa.projeto.eq(projeto)
                .and(qTarefa.concluida.eq(false)))
            .select(qTarefa)
            .fetchCount();
        
        Long totalAtividades = factory
            .from(qAtividade)
            .where(qAtividade.projeto.eq(projeto)
                .and(qAtividade.concluida.eq(false)))
            .select(qAtividade)
            .fetchCount();
        
        return (int)(totalTarefas + totalAtividades);
    }

    @Override
    public int tarefasFechadas(Projeto projeto) {
        QTarefa qTarefa = QTarefa.tarefa;
        QAtividade qAtividade = QAtividade.atividade;
        
        JPQLQueryFactory factory = new JPAQueryFactory(entityManager);
        
        Long totalTarefas = factory
            .from(qTarefa)
            .where(qTarefa.projeto.eq(projeto)
                .and(qTarefa.concluida.eq(true)))
            .select(qTarefa)
            .fetchCount();
        
        Long totalAtividades = factory
            .from(qAtividade)
            .where(qAtividade.projeto.eq(projeto)
                .and(qAtividade.concluida.eq(true)))
            .select(qAtividade)
            .fetchCount();
        
        return (int)(totalTarefas + totalAtividades);
    }
    
}