package siga;

/** Reação à matrícula. Pronta. Falha de propósito, para a etapa 4. */
public class AvisoCoordenacao implements OuvinteMatricula {

    /** A condição "turma lotada" saiu da fachada e passou a morar aqui. */
    @Override
    public void aoMatricular(EventoMatricula evento) {
        if (evento.turmaLotada()) {
            enviar(evento.matricula().getCodigoTurma());
        }
    }

    public void enviar(String codigoTurma) {
        throw new IllegalStateException(
                "servico de aviso indisponivel para " + codigoTurma);
    }
}
