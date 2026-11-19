package siga;

/**
 * Gerencia o fluxo de montagem do painel usando Factory Method.
 *
 * A classe não conhece as classes concretas PainelAluno, PainelProfessor,
 * PainelCoordenador ou PainelSecretaria. Ela trabalha apenas com o criador
 * abstrato e com o produto Painel.
 */
public class GerenciadorLogin {

    /**
     * Monta o painel por meio de um criador concreto.
     * O cliente escolhe o criador, enquanto a criação do produto fica
     * delegada ao Factory Method sobrescrito pela subclasse.
     */
    public Painel montarPainel(CriadorPainel criador) {
        if (criador == null) {
            throw new IllegalArgumentException("Criador de painel não pode ser nulo.");
        }

        return criador.montarPainel();
    }
}
