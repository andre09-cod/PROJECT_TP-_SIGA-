package siga;

/** Estratégia responsável por calcular o valor com desconto. */
public interface PoliticaDesconto {
    double calcular(Aluno aluno, double valorBase);
}
