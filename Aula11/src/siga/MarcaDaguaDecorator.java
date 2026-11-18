package siga;

/** Acrescenta a marca d'água ao final — escrita uma única vez. */
public class MarcaDaguaDecorator extends DecoratorRelatorio {

    private static final String MARCA = "*** RASCUNHO — NAO E DOCUMENTO OFICIAL ***";

    public MarcaDaguaDecorator(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public String gerar() {
        return super.gerar() + "\n" + MARCA;
    }
}
