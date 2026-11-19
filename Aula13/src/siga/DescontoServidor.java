package siga;

/** Política de desconto de 20% para servidores. */
public class DescontoServidor implements PoliticaDesconto {
    private static final double PERCENTUAL = 0.20;

    @Override
    public double calcular(Aluno aluno, double valorBase) {
        return aluno.isServidor() ? valorBase * (1.0 - PERCENTUAL) : valorBase;
    }
}
