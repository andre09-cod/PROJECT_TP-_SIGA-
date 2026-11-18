package siga;

/** Demonstra Strategy e Observer implementados na atividade. */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 13: Strategy e Observer ===");

        Aluno bolsista = new Aluno("2024001", "Maria Silva");
        bolsista.setBolsista(true);
        Aluno servidor = new Aluno("2024002", "Joao Souza");
        servidor.setServidor(true);
        Aluno egresso = new Aluno("2024003", "Ana Pereira");
        egresso.setEgresso(true);
        Aluno comum = new Aluno("2024004", "Carlos Lima");

        double valorBase = 800.00;
        SelecionadorPoliticaDesconto selecionador = new SelecionadorPoliticaDesconto();
        GeradorBoleto gerador = new GeradorBoleto();

        System.out.println("\n1) Strategy: matrícula e boleto usam a mesma política");
        for (Aluno aluno : new Aluno[] { bolsista, servidor, egresso, comum }) {
            PoliticaDesconto politica = selecionador.selecionar(aluno);
            Matricula matricula = new Matricula(aluno, "DSM-2A", politica);
            System.out.printf("   %-14s matricula: R$ %.2f%n",
                    aluno.getNome(), matricula.calcularValor(valorBase));
            gerador.emitir(aluno, valorBase, politica);
        }

        System.out.println("\n2) Observer: reações independentes à matrícula");
        FachadaMatricula fachada = new FachadaMatricula();
        fachada.adicionarObservador(new NotificadorSms()); // quinta reação: só esta linha

        System.out.println("\n   Matrícula em turma normal:");
        fachada.matricular(bolsista, "DSM-2A", false, selecionador.selecionar(bolsista));

        System.out.println("\n   Matrícula em turma lotada (aviso falha, auditoria e SMS continuam):");
        fachada.matricular(egresso, "DSM-2B", true, selecionador.selecionar(egresso));

        System.out.println("\n   Total de matrículas registradas: " + fachada.listar().size());
    }
}
