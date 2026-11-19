package siga;

/** Quinta reação adicionada como exemplo, sem alterar a FachadaMatricula. */
public class NotificadorSms implements ObservadorMatricula {
    @Override
    public void atualizar(EventoMatricula evento) {
        System.out.println("   [SMS] aviso de matricula enviado para "
                + evento.getMatricula().getAluno().getNome());
    }
}
