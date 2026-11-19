package siga;

import java.util.ArrayList;
import java.util.List;

/** Fachada mantém a orquestração da matrícula e delega as reações ao publicador. */
public class FachadaMatricula {
    private final List<Matricula> armazem = new ArrayList<>();
    private final PublicadorMatricula publicador = new PublicadorMatricula();

    public FachadaMatricula() {
        publicador.adicionarObservador(new NotificadorEmail());
        publicador.adicionarObservador(new PainelVagas());
        publicador.adicionarObservador(new AvisoCoordenacao());
        publicador.adicionarObservador(new RegistroAuditoria());
    }

    /** Permite acrescentar novas reações sem modificar esta fachada. */
    public void adicionarObservador(ObservadorMatricula observador) {
        publicador.adicionarObservador(observador);
    }

    public Matricula matricular(Aluno aluno, String codigoTurma, boolean turmaLotada,
                                PoliticaDesconto politicaDesconto) {
        Matricula nova = new Matricula(aluno, codigoTurma, politicaDesconto);
        armazem.add(nova);
        publicador.publicar(new EventoMatricula(nova, turmaLotada));
        return nova;
    }

    public List<Matricula> listar() {
        return new ArrayList<>(armazem);
    }
}
