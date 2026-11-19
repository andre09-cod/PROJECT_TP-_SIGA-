package siga;

/**
 * Demonstração isolada da Etapa 2 (Simple Factory).
 * Mantida para registrar a etapa anterior da refatoração.
 */
public class MainSimpleFactory {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Demonstração Simple Factory ===\n");

        PainelFactory.criarPainel("ALUNO").montar();
        System.out.println();
        PainelFactory.criarPainel("PROFESSOR").montar();
        System.out.println();
        PainelFactory.criarPainel("COORDENADOR").montar();
    }
}
