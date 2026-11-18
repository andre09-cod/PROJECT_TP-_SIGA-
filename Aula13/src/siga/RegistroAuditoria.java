package siga;

/** Reação que registra a matrícula para auditoria. */
public class RegistroAuditoria implements ObservadorMatricula {
    @Override
    public void atualizar(EventoMatricula evento) {
        System.out.println("   [auditoria] MATRICULA - "
                + evento.getMatricula().getAluno().getMatricula());
    }
}
