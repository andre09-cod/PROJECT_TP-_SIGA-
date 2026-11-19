# Respostas às etapas da atividade

1. **Trechos legados e divergência:** o legado retorna texto (`List<String>`) em `SecretariaLegadoWS.consultarAlunos`; o sistema novo espera objetos `Aluno` por meio de `FonteDeAlunos`. A conversão de formato e tipo fica isolada em `AdaptadorSecretariaLegado`.
2. **Interface e Adapter:** `FonteDeAlunos` define `listarAlunos()` e `AdaptadorSecretariaLegado` implementa a interface usando composição: recebe `SecretariaLegadoWS` no construtor.
3. **Refatoração:** `ImportadorAlunos` usa `FonteDeAlunos`; `RelatorioSituacao` trabalha com `Aluno`. Nenhuma dessas classes referencia `SecretariaLegadoWS`.
4. **Facade:** `FachadaMatricula` coordena importação e relatório. `TelaMatricula` tem somente a fachada como colaborador e faz a chamada com tratamento de erro.
5. **Justificativa:** Adapter foi escolhido porque o formato legado é incompatível com a interface do sistema novo. Facade foi escolhida para simplificar o uso do conjunto de serviços pela tela e esconder a ordem de execução.
