package siga;

import java.util.ArrayList;
import java.util.List;

/** Mantém os ouvintes e notifica cada um sem deixar uma falha interromper os demais. */
public class PublicadorMatricula {
    private final List<ObservadorMatricula> observadores = new ArrayList<>();

    public void adicionarObservador(ObservadorMatricula observador) {
        observadores.add(observador);
    }

    public void publicar(EventoMatricula evento) {
        for (ObservadorMatricula observador : observadores) {
            try {
                observador.atualizar(evento);
            } catch (RuntimeException erro) {
                System.out.println("   [aviso] uma reação falhou: " + erro.getMessage());
            }
        }
    }
}
