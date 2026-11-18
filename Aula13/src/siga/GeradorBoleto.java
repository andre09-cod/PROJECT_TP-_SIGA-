package siga;

/** Gera o boleto usando a mesma política escolhida para a matrícula. */
public class GeradorBoleto {
    public double calcularValorDoBoleto(Aluno aluno, double valorBase,
                                        PoliticaDesconto politicaDesconto) {
        return politicaDesconto.calcular(aluno, valorBase);
    }

    public void emitir(Aluno aluno, double valorBase, PoliticaDesconto politicaDesconto) {
        double valor = calcularValorDoBoleto(aluno, valorBase, politicaDesconto);
        System.out.printf("   [boleto] %s: R$ %.2f%n", aluno.getNome(), valor);
    }
}
