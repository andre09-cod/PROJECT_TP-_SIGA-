package siga;

/** SIGA - Aula 12: Strategy e Observer (codigo refatorado). */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 12: Strategy e Observer (codigo refatorado) ===");

        Aluno bolsista = new Aluno("2024001", "Maria Silva");
        bolsista.setBolsista(true);

        Aluno egresso = new Aluno("2024003", "Ana Pereira");
        egresso.setEgresso(true);

        double valorBase = 800.00;
        GeradorBoleto gerador = new GeradorBoleto();

        System.out.println();
        System.out.println("1) Desconto decidido em UM so lugar (Strategy)");
        for (Aluno a : new Aluno[] { bolsista, egresso }) {
            Matricula m = new Matricula(a, "DSM-2A", PoliticasDesconto.para(a));
            double naMatricula = m.calcularValor(valorBase);
            double noBoleto = gerador.calcularValorDoBoleto(m, valorBase);
            System.out.printf("   %-14s matricula: R$ %.2f | boleto: R$ %.2f | iguais: %b%n",
                    a.getNome(), naMatricula, noBoleto, naMatricula == noBoleto);
            gerador.emitir(m, valorBase);
        }

        System.out.println();
        System.out.println("2) Reacoes a matricula via publicador (Observer)");
        PublicadorMatricula publicador = new PublicadorMatricula();
        publicador.adicionar(new NotificadorEmail());
        publicador.adicionar(new PainelVagas());
        publicador.adicionar(new AvisoCoordenacao());
        publicador.adicionar(new RegistroAuditoria());
        publicador.adicionar(new IntegracaoBiblioteca());   // etapa 5: unica linha de registro
        FachadaMatricula fachada = new FachadaMatricula(publicador);
        fachada.matricular(bolsista, "DSM-2A", false);

        System.out.println();
        System.out.println("   Agora com a turma lotada, e o aviso a coordenacao falhando:");
        fachada.matricular(egresso, "DSM-2B", true);
        System.out.println("   >> A falha do aviso foi registrada, e a auditoria (que vem depois) executou.");
        System.out.println("   Matriculas gravadas: " + fachada.listar().size());
    }
}
