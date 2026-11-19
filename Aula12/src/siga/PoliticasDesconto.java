package siga;

/**
 * Único ponto que decide QUAL política vale para um aluno (precedência:
 * bolsista, servidor, egresso). Matricula e GeradorBoleto não conhecem
 * essa regra; só recebem a política já escolhida.
 */
public final class PoliticasDesconto {

    private PoliticasDesconto() { }

    public static PoliticaDesconto para(Aluno aluno) {
        if (aluno.isBolsista()) {
            return new PoliticaBolsista();
        } else if (aluno.isServidor()) {
            return new PoliticaServidor();
        } else if (aluno.isEgresso()) {
            return new PoliticaEgresso();
        }
        return new PoliticaSemDesconto();
    }
}
