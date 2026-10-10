# Atividade — Padrões Estruturais: Adapter e Facade

## Como executar

Requisito: JDK 17 ou superior (o projeto usa `record` e `List.of`).

No terminal, dentro da pasta `src/main/java`, execute:

```bash
javac -d ../../../../out $(find . -name '*.java')
java -cp ../../../../out siga.Main
```

Ou compile todos os arquivos Java pela IDE, executando `siga.Main`.

## Padrões aplicados

### Adapter
`SecretariaLegadoWS` é o serviço antigo: entrega cada aluno como uma linha de texto no formato `MATRICULA;NOME;MEDIA`. O sistema novo espera `FonteDeAlunos`, que retorna objetos `Aluno`. `AdaptadorSecretariaLegado` implementa essa interface e converte os registros antigos em objetos do modelo novo.

Os dois pontos de conversão são: (1) a leitura da lista textual produzida por `SecretariaLegadoWS`; e (2) a separação dos campos e conversão da média para `double` dentro de `AdaptadorSecretariaLegado`.

### Facade
`FachadaMatricula` fornece à tela uma operação simples (`executarMatricula`) e coordena `ImportadorAlunos` e `RelatorioSituacao`. Assim, a tela não precisa conhecer os detalhes da importação nem da geração do relatório.

## Decisões de projeto
- `ImportadorAlunos` e `RelatorioSituacao` dependem de `FonteDeAlunos`/`Aluno`, não da classe legada `SecretariaLegadoWS`.
- `TelaMatricula` possui apenas um colaborador: `FachadaMatricula`. Ela chama a fachada e trata possíveis erros.
- A composição é usada para montar os objetos e injetar suas dependências.

## Saída esperada

```text
Relatório de situação dos alunos
2026001 - Ana Souza - Média: 8.5 - Aprovado
2026002 - Bruno Lima - Média: 7.0 - Aprovado
2026003 - Carla Mendes - Média: 9.2 - Aprovado
```
