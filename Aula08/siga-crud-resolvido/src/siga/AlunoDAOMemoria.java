package siga;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do DAO que mantém os alunos em uma lista na memória.
 * Esta classe cuida do armazenamento, não das regras de validação do domínio.
 */
public class AlunoDAOMemoria implements AlunoDAO {
    private final List<Aluno> armazem = new ArrayList<>();

    @Override
    public void inserir(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        if (buscarPorMatricula(aluno.getMatricula()) != null) {
            throw new IllegalStateException(
                    "Já existe aluno cadastrado com a matrícula " + aluno.getMatricula() + ".");
        }
        armazem.add(aluno);
    }

    @Override
    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno aluno : armazem) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> listarTodos() {
        // Cópia defensiva: o chamador não recebe a lista interna do DAO.
        return new ArrayList<>(armazem);
    }

    @Override
    public void atualizar(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }

        for (int i = 0; i < armazem.size(); i++) {
            if (armazem.get(i).getMatricula().equals(aluno.getMatricula())) {
                armazem.set(i, aluno);
                return;
            }
        }
        throw new IllegalArgumentException(
                "Não existe aluno com a matrícula " + aluno.getMatricula() + ".");
    }

    @Override
    public void remover(String matricula) {
        Aluno encontrado = buscarPorMatricula(matricula);
        if (encontrado == null) {
            throw new IllegalArgumentException(
                    "Não existe aluno com a matrícula " + matricula + ".");
        }
        armazem.remove(encontrado);
    }
}
