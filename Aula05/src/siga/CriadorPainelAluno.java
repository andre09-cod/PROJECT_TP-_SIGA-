package siga;

/** Criador concreto responsável pelo painel do aluno. */
public class CriadorPainelAluno extends CriadorPainel {

    @Override
    protected Painel criarPainel() {
        return new PainelAluno();
    }
}
