package siga;

/**
 * Simple Factory: centraliza a criação dos painéis.
 *
 * A fábrica recebe o tipo de usuário e devolve o produto (Painel) adequado.
 * Assim, o código cliente não precisa usar new nas classes concretas.
 */
public class PainelFactory {

    public static Painel criarPainel(String tipoUsuario) {
        if (tipoUsuario == null) {
            throw new IllegalArgumentException("Perfil desconhecido: null");
        }

        switch (tipoUsuario.toUpperCase()) {
            case "ALUNO":
                return new PainelAluno();
            case "PROFESSOR":
                return new PainelProfessor();
            case "COORDENADOR":
                return new PainelCoordenador();
            case "SECRETARIA":
                return new PainelSecretaria();
            default:
                throw new IllegalArgumentException("Perfil desconhecido: " + tipoUsuario);
        }
    }
}
