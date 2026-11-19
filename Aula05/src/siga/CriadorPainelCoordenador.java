package siga;

/** Criador concreto responsável pelo painel do coordenador. */
public class CriadorPainelCoordenador extends CriadorPainel {

    @Override
    protected Painel criarPainel() {
        return new PainelCoordenador();
    }
}
