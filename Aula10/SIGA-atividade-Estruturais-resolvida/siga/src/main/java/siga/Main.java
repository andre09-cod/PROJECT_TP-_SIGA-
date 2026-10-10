package siga;

import siga.fonte.AdaptadorSecretariaLegado;
import siga.legado.SecretariaLegadoWS;
import siga.matricula.FachadaMatricula;
import siga.matricula.ImportadorAlunos;
import siga.matricula.RelatorioSituacao;
import siga.ui.TelaMatricula;

/** Ponto de entrada da aplicação demonstrativa. */
public class Main {
    public static void main(String[] args) {
        // O Adapter faz a ponte entre o serviço antigo e a interface esperada.
        AdaptadorSecretariaLegado adaptador =
                new AdaptadorSecretariaLegado(new SecretariaLegadoWS());
        // Os serviços do sistema novo dependem da interface, não da classe legada.
        ImportadorAlunos importador = new ImportadorAlunos(adaptador);
        RelatorioSituacao relatorio = new RelatorioSituacao();
        // A Facade reúne os passos e a tela conhece apenas a Facade.
        FachadaMatricula fachada = new FachadaMatricula(importador, relatorio);
        new TelaMatricula(fachada).abrir();
    }
}
