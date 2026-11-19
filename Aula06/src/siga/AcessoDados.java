package siga;

/**
 * Ponto único de acesso aos dados.
 *
 * Padrão aplicado: Singleton.
 * A criação da família de objetos de banco é delegada ao Abstract Factory e a
 * montagem de consultas é delegada ao Builder.
 */
public final class AcessoDados {
    private static AcessoDados instancia;

    private AcessoDados() {
        // Impede new AcessoDados() fora desta classe.
    }

    /** Retorna a única instância do acesso a dados. */
    public static synchronized AcessoDados getInstancia() {
        if (instancia == null) {
            instancia = new AcessoDados();
        }
        return instancia;
    }

    /**
     * Usa uma fábrica concreta para produzir uma família coerente de produtos.
     * Não existe mais if/new separado para conexão e comando.
     */
    public void conectar(FabricaBanco fabrica) {
        if (fabrica == null) {
            throw new IllegalArgumentException("A fábrica deve ser informada.");
        }

        Conexao conexao = fabrica.criarConexao();
        Comando comando = fabrica.criarComando();

        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }

    /** Executa uma consulta montada pelo Builder. */
    public void executarConsulta(FabricaBanco fabrica, String consulta) {
        if (fabrica == null) {
            throw new IllegalArgumentException("A fábrica deve ser informada.");
        }
        if (consulta == null || consulta.isBlank()) {
            throw new IllegalArgumentException("A consulta deve ser informada.");
        }

        fabrica.criarComando().executar(consulta);
    }
}
