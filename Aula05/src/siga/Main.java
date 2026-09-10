package siga;

/**
 * Demonstração final da atividade: Factory Method.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade Factory Method ===\n");

        GerenciadorLogin login = new GerenciadorLogin();

        login.montarPainel(new CriadorPainelAluno());
        System.out.println();
        login.montarPainel(new CriadorPainelProfessor());
        System.out.println();
        login.montarPainel(new CriadorPainelCoordenador());
        System.out.println();

        // Etapa 4: novo perfil adicionado apenas com novas classes.
        login.montarPainel(new CriadorPainelSecretaria());
    }
}
