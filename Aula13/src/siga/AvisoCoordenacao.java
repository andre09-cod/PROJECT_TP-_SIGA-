package siga;

/** Reação da coordenação; simula uma indisponibilidade para testar isolamento. */
public class AvisoCoordenacao implements ObservadorMatricula {
    @Override
    public void atualizar(EventoMatricula evento) {
        if (evento.isTurmaLotada()) {
            throw new IllegalStateException("servico de aviso indisponivel para "
                    + evento.getMatricula().getCodigoTurma());
        }
        // Sem ação quando a turma não está lotada.
    }
}
