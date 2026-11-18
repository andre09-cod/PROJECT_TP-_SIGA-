package siga;

/**
 * Usa a MESMA política da matrícula: sem if de desconto e sem divergência
 * possível entre o valor da matrícula e o do boleto.
 */
public class GeradorBoleto {

    public double calcularValorDoBoleto(Matricula matricula, double valorBase) {
        return matricula.getPolitica().aplicar(valorBase);
    }

    public void emitir(Matricula matricula, double valorBase) {
        double valor = calcularValorDoBoleto(matricula, valorBase);
        System.out.printf("   [boleto] %s: R$ %.2f%n", matricula.getAluno().getNome(), valor);
    }
}
