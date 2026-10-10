package siga.fonte;

import java.util.List;

/** Contrato esperado pelo sistema novo para obter alunos. */
public interface FonteDeAlunos {
    List<Aluno> listarAlunos();
}
