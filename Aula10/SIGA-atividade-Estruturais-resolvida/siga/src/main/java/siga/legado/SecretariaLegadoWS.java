package siga.legado;

import java.util.List;

/** Serviço legado: devolve alunos em texto, no formato MATRICULA;NOME;MEDIA. */
public class SecretariaLegadoWS {
    public List<String> consultarAlunos() {
        return List.of(
            "2026001;Ana Souza;8.5",
            "2026002;Bruno Lima;7.0",
            "2026003;Carla Mendes;9.2"
        );
    }
}
