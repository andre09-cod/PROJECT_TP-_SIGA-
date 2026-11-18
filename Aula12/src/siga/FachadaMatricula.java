package siga;

import java.util.ArrayList;
import java.util.List;

/**
 * Continua orquestrando os PASSOS (criar, gravar), mas não conhece mais
 * nenhuma reação: apenas publica o fato. Nova reação = nenhuma alteração aqui.
 */
public class FachadaMatricula {

    private final List<Matricula> armazem = new ArrayList<>();
    private final PublicadorMatricula publicador;

    public FachadaMatricula(PublicadorMatricula publicador) {
        this.publicador = publicador;
    }

    public Matricula matricular(Aluno aluno, String codigoTurma, boolean turmaLotada) {
        Matricula nova = new Matricula(aluno, codigoTurma, PoliticasDesconto.para(aluno));
        armazem.add(nova);

        publicador.publicar(new EventoMatricula(nova, turmaLotada));

        return nova;
    }

    public List<Matricula> listar() {
        return new ArrayList<>(armazem);
    }
}
