package siga;

/** Produto concreto adicionado na Etapa 4: painel da SECRETARIA. */
public class PainelSecretaria implements Painel {

    @Override
    public void montar() {
        System.out.println("=== Painel da Secretaria ===");
        System.out.println("- Atendimento aos alunos");
        System.out.println("- Emissão de documentos");
        System.out.println("- Organização de matrículas");
    }
}
