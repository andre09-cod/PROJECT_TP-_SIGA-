package siga.matricula;

import siga.fonte.Aluno;
import java.util.List;

/** Facade: oferece uma única operação para a tela e coordena importação e relatório. */
public class FachadaMatricula {
    private final ImportadorAlunos importador;
    private final RelatorioSituacao relatorio;

    public FachadaMatricula(ImportadorAlunos importador, RelatorioSituacao relatorio) {
        this.importador = importador;
        this.relatorio = relatorio;
    }

    public String executarMatricula() {
        List<Aluno> alunos = importador.importar();
        return relatorio.gerar(alunos);
    }
}
