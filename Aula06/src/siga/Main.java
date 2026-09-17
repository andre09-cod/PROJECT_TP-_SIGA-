package siga;

/** Demonstração dos três padrões criacionais aplicados. */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIGA - Padrões Criacionais ===\n");

        // Singleton: as duas variáveis apontam para a mesma instância.
        AcessoDados acesso1 = AcessoDados.getInstancia();
        AcessoDados acesso2 = AcessoDados.getInstancia();
        System.out.println("Singleton: mesma instância? " + (acesso1 == acesso2));
        System.out.println();

        // Abstract Factory: cada fábrica cria conexão + comando da mesma família.
        FabricaBanco fabricaMySQL = new FabricaMySQL();
        FabricaBanco fabricaPostgreSQL = new FabricaPostgreSQL();

        acesso1.conectar(fabricaMySQL);
        System.out.println();
        acesso1.conectar(fabricaPostgreSQL);

        System.out.println();

        // Builder: parâmetros opcionais ficam nomeados e encadeáveis.
        ConsultaBuilder builder = ConsultaBuilder.paraTabela("aluno")
                .comFiltro("curso = 'DSM'")
                .somenteAtivos()
                .comOrdenacao("nome")
                .comLimite(50)
                .comOffset(0)
                .comTimeout(30);

        String consulta = builder.construir();
        System.out.println("Consulta montada: " + consulta);
        System.out.println("Timeout configurado: " + builder.getTimeoutSegundos() + " segundos");

        System.out.println("\nExecução da consulta com a família MySQL:");
        acesso1.executarConsulta(fabricaMySQL, consulta);
    }
}
