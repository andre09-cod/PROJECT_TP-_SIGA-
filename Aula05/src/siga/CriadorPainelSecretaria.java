package siga;

/**
 * Novo criador concreto da Etapa 4.
 * Não é necessário alterar os criadores existentes para adicionar SECRETARIA.
 */
public class CriadorPainelSecretaria extends CriadorPainel {

    @Override
    protected Painel criarPainel() {
        return new PainelSecretaria();
    }
}
