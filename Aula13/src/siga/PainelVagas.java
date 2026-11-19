package siga;

/** Reação que atualiza o painel de vagas. */
public class PainelVagas implements ObservadorMatricula {
    @Override
    public void atualizar(EventoMatricula evento) {
        System.out.println("   [painel] vagas de "
                + evento.getMatricula().getCodigoTurma() + " atualizadas");
    }
}
