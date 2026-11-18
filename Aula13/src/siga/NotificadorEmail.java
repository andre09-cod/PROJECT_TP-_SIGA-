package siga;

/** Reação que envia a confirmação por e-mail. */
public class NotificadorEmail implements ObservadorMatricula {
    @Override
    public void atualizar(EventoMatricula evento) {
        System.out.println("   [e-mail] confirmacao para "
                + evento.getMatricula().getAluno().getNome());
    }
}
