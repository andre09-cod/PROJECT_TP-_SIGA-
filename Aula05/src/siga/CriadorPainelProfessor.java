package siga;

/** Criador concreto responsável pelo painel do professor. */
public class CriadorPainelProfessor extends CriadorPainel {

    @Override
    protected Painel criarPainel() {
        return new PainelProfessor();
    }
}
