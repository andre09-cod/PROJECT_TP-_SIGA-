package siga;

/** Acrescenta o cabeçalho institucional — escrito uma única vez. */
public class CabecalhoDecorator extends DecoratorRelatorio {

    private static final String CABECALHO =
            "FATEC DE PORTO FERREIRA\n"
          + "Sistema de Gestao Academica\n"
          + "---\n";

    public CabecalhoDecorator(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public String gerar() {
        return CABECALHO + super.gerar();
    }
}
