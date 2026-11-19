package siga.matricula;

import siga.fonte.Aluno;
import siga.fonte.FonteDeAlunos;
import java.util.List;

/** Importa alunos usando a interface, sem conhecer o serviço legado. */
public class ImportadorAlunos {
    private final FonteDeAlunos fonte;

    public ImportadorAlunos(FonteDeAlunos fonte) {
        this.fonte = fonte;
    }

    public List<Aluno> importar() {
        return fonte.listarAlunos();
    }
}
