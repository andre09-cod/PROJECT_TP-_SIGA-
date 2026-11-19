package siga;

import java.util.List;

/**
 * Camada de serviço: aplica as regras de negócio antes de chamar o DAO.
 */
public class ServicoAluno {
    private final AlunoDAO dao;

    public ServicoAluno(AlunoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Aluno aluno) {
        validar(aluno);
        dao.inserir(aluno);
    }

    public List<Aluno> listar() {
        return dao.listarTodos();
    }

    public Aluno consultar(String matricula) {
        Aluno aluno = dao.buscarPorMatricula(matricula);
        if (aluno == null) {
            throw new IllegalArgumentException(
                    "Aluno não encontrado para a matrícula " + matricula + ".");
        }
        return aluno;
    }

    public void alterar(Aluno aluno) {
        validar(aluno);
        // Confirma a existência antes de solicitar a atualização.
        consultar(aluno.getMatricula());
        dao.atualizar(aluno);
    }

    public void excluir(String matricula) {
        // Confirma a existência e deixa o DAO efetuar a remoção.
        consultar(matricula);
        dao.remover(matricula);
    }

    /** Regra de domínio centralizada: é o único lugar que valida os dados. */
    private void validar(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (aluno.getMatricula() == null || aluno.getMatricula().isBlank()) {
            throw new IllegalArgumentException("Matrícula é obrigatória.");
        }
        if (aluno.getMedia() < 0 || aluno.getMedia() > 10) {
            throw new IllegalArgumentException("Média deve estar entre 0 e 10.");
        }
    }
}
