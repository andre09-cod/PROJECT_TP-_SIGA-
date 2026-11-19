package siga;

/** Quinta reação: cria o cadastro do aluno na biblioteca. */
public class IntegracaoBiblioteca implements OuvinteMatricula {

    @Override
    public void aoMatricular(EventoMatricula evento) {
        System.out.println("   [biblioteca] cadastro criado para "
                + evento.matricula().getAluno().getNome());
    }
}
