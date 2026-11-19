package siga.matricula;

import siga.fonte.Aluno;
import java.util.List;

/** Gera um resumo simples da situação dos alunos importados. */
public class RelatorioSituacao {
    public String gerar(List<Aluno> alunos) {
        StringBuilder texto = new StringBuilder("Relatório de situação dos alunos\n");
        for (Aluno aluno : alunos) {
            String situacao = aluno.media() >= 6.0 ? "Aprovado" : "Em recuperação";
            texto.append(aluno.matricula()).append(" - ")
                 .append(aluno.nome()).append(" - Média: ")
                 .append(aluno.media()).append(" - ").append(situacao).append('\n');
        }
        return texto.toString();
    }
}
