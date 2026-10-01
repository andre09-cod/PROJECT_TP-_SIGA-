package siga;

import java.util.List;

/** Contrato de acesso aos dados dos alunos (DAO). */
public interface AlunoDAO {
    void inserir(Aluno aluno);                   // Create
    Aluno buscarPorMatricula(String matricula);  // Read - um
    List<Aluno> listarTodos();                   // Read - todos
    void atualizar(Aluno aluno);                 // Update
    void remover(String matricula);              // Delete
}
