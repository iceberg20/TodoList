package br.edu.ifrn.todo.persistencia;

import br.edu.ifrn.todo.dominio.Intervalo;
import java.time.LocalTime;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class IntervaloFactory {
    public final static LocalTime inicio = LocalTime.of(9, 9);
    public final static LocalTime fim = LocalTime.of(10, 10);

    @Inject
    private IntervaloRepository intervaloRepository;
    
    public Intervalo intervalo() {
        Intervalo intervalo = Intervalo.builder()
                .horaInicio(inicio)
                .horaFim(fim)
                .build();
        intervaloRepository.save(intervalo);
        return intervalo;
    }
}
