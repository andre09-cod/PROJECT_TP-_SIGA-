package siga;

/**
 * SIGA - Aula 11: Decorator e Composite (código refatorado).
 * Etapas 3 e 5 da ficha de atividade prática vivem aqui, no cliente.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 11: Decorator e Composite (codigo refatorado) ===");

        // ---------------------------------------------------------------
        // ETAPA 3 — pilhas de decoradores montadas pelo cliente
        // ---------------------------------------------------------------
        System.out.println();
        System.out.println("1) Relatorios: decoradores empilhados sobre a mesma classe base");

        Relatorio simples = new RelatorioDeAlunos();

        // Pilha A: cabeçalho por fora de numeração
        Relatorio pilhaA = new CabecalhoDecorator(new NumeracaoDecorator(new RelatorioDeAlunos()));

        // Pilha B: cabeçalho + numeração + marca d'água
        Relatorio pilhaB = new MarcaDaguaDecorator(
                new CabecalhoDecorator(
                        new NumeracaoDecorator(new RelatorioDeAlunos())));

        // Pilha C: só marca d'água (combinação que nunca existiu como subclasse)
        Relatorio pilhaC = new MarcaDaguaDecorator(new RelatorioDeAlunos());

        exibir("RelatorioDeAlunos (sem decoradores)", simples);
        exibir("Cabecalho(Numeracao(Alunos))", pilhaA);
        exibir("MarcaDagua(Cabecalho(Numeracao(Alunos)))", pilhaB);
        exibir("MarcaDagua(Alunos)", pilhaC);

        // ---------------------------------------------------------------
        // ETAPA 4 — Composite: o cliente não pergunta tipo nenhum
        // ---------------------------------------------------------------
        System.out.println();
        System.out.println("2) Estrutura curricular tratada de modo uniforme (Composite)");
        Modulo curso = new Modulo("DSM - Desenvolvimento de Software Multiplataforma");

        Modulo primeiro = new Modulo("1o semestre");
        primeiro.adicionar(new Disciplina("Algoritmos", 80));
        primeiro.adicionar(new Disciplina("Banco de Dados I", 60));

        Modulo segundo = new Modulo("2o semestre");
        segundo.adicionar(new Disciplina("Tecnicas de Programacao II", 80));
        segundo.adicionar(new Disciplina("Desenvolvimento Web II", 80));

        curso.adicionar(primeiro);
        curso.adicionar(segundo);
        curso.adicionar(new Disciplina("Projeto Integrador", 40));

        ItemCurricular item = curso;
        item.imprimir(1);
        System.out.println("   Carga total: " + item.getCargaHoraria() + "h");

        // ---------------------------------------------------------------
        // ETAPA 5 — submódulo de terceiro nível: só a MONTAGEM da árvore
        // muda; as duas linhas do cliente acima (imprimir e getCargaHoraria)
        // continuam exatamente iguais.
        // ---------------------------------------------------------------
        System.out.println();
        System.out.println("3) Mesma estrutura, agora com um submodulo de terceiro nivel");
        Modulo optativas = new Modulo("Optativas do 2o semestre");
        optativas.adicionar(new Disciplina("Ingles Tecnico", 40));
        optativas.adicionar(new Disciplina("Computacao em Nuvem", 40));
        segundo.adicionar(optativas);

        item.imprimir(1);
        System.out.println("   Carga total: " + item.getCargaHoraria() + "h");
    }

    private static void exibir(String titulo, Relatorio r) {
        System.out.println("   --- " + titulo + " ---");
        for (String linha : r.gerar().split("\n")) {
            System.out.println("   " + linha);
        }
    }
}
