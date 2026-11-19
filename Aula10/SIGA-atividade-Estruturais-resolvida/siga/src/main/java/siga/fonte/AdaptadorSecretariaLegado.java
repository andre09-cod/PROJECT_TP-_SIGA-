package siga.fonte;

import siga.legado.SecretariaLegadoWS;
import java.util.ArrayList;
import java.util.List;

/** Adapter: converte o formato textual legado para o modelo Aluno. */
public class AdaptadorSecretariaLegado implements FonteDeAlunos {
    private final SecretariaLegadoWS secretariaLegado;

    public AdaptadorSecretariaLegado(SecretariaLegadoWS secretariaLegado) {
        this.secretariaLegado = secretariaLegado;
    }

    @Override
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        for (String linha : secretariaLegado.consultarAlunos()) {
            String[] campos = linha.split(";", -1);
            if (campos.length != 3) {
                throw new IllegalArgumentException("Registro legado inválido: " + linha);
            }
            alunos.add(new Aluno(campos[0].trim(), campos[1].trim(),
                    Double.parseDouble(campos[2].trim())));
        }
        return alunos;
    }
}
