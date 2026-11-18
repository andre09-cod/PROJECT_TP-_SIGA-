package siga;

/**
 * Decorator base: é um Relatorio e TEM um Relatorio. Por padrão apenas
 * delega; cada decorador concreto acrescenta o seu comportamento antes
 * e/ou depois da chamada ao relatório embrulhado.
 */
public abstract class DecoratorRelatorio implements Relatorio {

    protected final Relatorio relatorio;

    protected DecoratorRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public String gerar() {
        return relatorio.gerar();
    }
}
