package siga;

/** Camada de apresentação: executa operações e mostra mensagens ao usuário. */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIGA - CRUD resolvido ===");

        AlunoDAO dao = new AlunoDAOMemoria();
        ServicoAluno servico = new ServicoAluno(dao);

        // CREATE: cadastrar alunos.
        executar("Cadastrar Maria", () ->
                servico.cadastrar(new Aluno("Maria Silva", "2026001", 8.5)));
        executar("Cadastrar João", () ->
                servico.cadastrar(new Aluno("João Souza", "2026002", 6.0)));

        // READ: consultar um aluno e listar todos.
        executar("Consultar Maria", () ->
                System.out.println(servico.consultar("2026001")));
        System.out.println("\nAlunos cadastrados:");
        servico.listar().forEach(aluno -> System.out.println("  " + aluno));

        // UPDATE: alterar a média, mantendo a mesma matrícula.
        executar("Atualizar Maria", () -> {
            servico.alterar(new Aluno("Maria Silva", "2026001", 9.0));
            System.out.println("Dados atualizados: " + servico.consultar("2026001"));
        });

        // DELETE: excluir um aluno existente.
        executar("Excluir João", () -> {
            servico.excluir("2026002");
            System.out.println("Aluno excluído.");
        });

        // Testes dos erros tratados: duplicidade, média inválida e matrícula ausente.
        executar("Testar matrícula duplicada", () ->
                servico.cadastrar(new Aluno("Outra pessoa", "2026001", 7.0)));
        executar("Testar média fora do intervalo", () ->
                servico.cadastrar(new Aluno("Aluno Inválido", "2026003", 50)));
        executar("Testar exclusão de matrícula inexistente", () ->
                servico.excluir("0000000"));

        // Teste da cópia defensiva: alterar esta lista não altera o DAO.
        servico.listar().clear();
        System.out.println("\nQuantidade após limpar a lista recebida: "
                + servico.listar().size() + " (os dados internos continuam protegidos)");
    }

    /** Captura erros na apresentação e apresenta mensagens claras. */
    private static void executar(String operacao, Runnable acao) {
        try {
            acao.run();
            System.out.println(operacao + ": concluído.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(operacao + ": não foi possível - " + e.getMessage());
        }
    }
}
