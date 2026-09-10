package siga;

/**
 * Criador abstrato do padrão Factory Method.
 * A classe define o método de fábrica que será sobrescrito pelas subclasses.
 */
public abstract class CriadorPainel {

    /**
     * Factory Method: cada subclasse decide qual Painel concreto criar.
     */
    protected abstract Painel criarPainel();

    /**
     * Fluxo comum para montar o painel.
     */
    public Painel montarPainel() {
        Painel painel = criarPainel();
        painel.montar();
        return painel;
    }
}
