# SIGA — Aula 12: Strategy e Observer (atividade respondida)

## Etapa 1 — As duas cadeias de condicionais de desconto

As cadeias estão em `Matricula.calcularValor` e em `GeradorBoleto.calcularValorDoBoleto`.

| Classe          | Bolsista | Servidor | Egresso            |
|-----------------|----------|----------|--------------------|
| `Matricula`     | 50%      | 80%      | **90%**            |
| `GeradorBoleto` | 50%      | 80%      | **ausente** (devolve o valor cheio) |

**Onde divergem:** a política do egresso foi criada em `Matricula`, mas ninguém atualizou a cópia
da cadeia em `GeradorBoleto`.

**Aluna afetada:** **Ana Pereira** (egresso, matrícula 2024003). Para um valor base de R$ 800,00,
ela paga **R$ 720,00 na matrícula** e **R$ 800,00 no boleto**. Bolsistas e servidores não são
afetados, pois as duas cadeias coincidem para eles.

## Etapa 2 — Interface `PoliticaDesconto` e as quatro políticas

`PoliticaDesconto` (`double aplicar(double valorBase)`) e as implementações
`PoliticaSemDesconto` (100%), `PoliticaBolsista` (50%), `PoliticaServidor` (80%) e
`PoliticaEgresso` (90%). Cada percentual aparece **uma única vez** em todo o projeto.

`PoliticasDesconto.para(aluno)` é o único lugar que decide qual política vale para cada aluno
(mantendo a precedência original: bolsista, servidor, egresso).

## Etapa 3 — Estratégia injetada em `Matricula` e usada por `GeradorBoleto`

- `Matricula` recebe a `PoliticaDesconto` no construtor e delega o cálculo a ela.
- `GeradorBoleto` recebe a `Matricula` e usa `matricula.getPolitica()`: é **a mesma política**.
- Nenhum `if` de desconto restou nas duas classes.

Evidência (saída do `Main`): Ana Pereira passa a pagar **R$ 720,00 na matrícula e R$ 720,00 no
boleto** (`iguais: true`); Maria Silva, R$ 400,00 nos dois pontos.

## Etapa 4 — Observer: `OuvinteMatricula` e `PublicadorMatricula`

- `OuvinteMatricula.aoMatricular(EventoMatricula)`; o evento carrega a matrícula e o indicador
  `turmaLotada`.
- As quatro reações (`NotificadorEmail`, `PainelVagas`, `AvisoCoordenacao`, `RegistroAuditoria`)
  viraram ouvintes. A condição "turma lotada" saiu da fachada e foi para `AvisoCoordenacao`.
- `PublicadorMatricula.publicar` **percorre uma cópia da lista** (`new ArrayList<>(ouvintes)`) e
  **protege cada chamada** com `try/catch`: a falha de um ouvinte é registrada e os seguintes
  continuam.
- `FachadaMatricula` só cria e grava a matrícula e publica o evento; não conhece mais nenhuma reação.

Evidência: com a turma lotada, `AvisoCoordenacao` falha (`[erro] ...`), mas a auditoria, que vem
depois dele, **executa**. No código original, a falha derrubava tudo o que vinha em seguida.

## Etapa 5 — Quinta reação sem alterar `FachadaMatricula`

Acrescentados apenas:

1. **Uma classe nova:** `IntegracaoBiblioteca` (cria o cadastro do aluno na biblioteca).
2. **Uma linha de registro** no `Main`: `publicador.adicionar(new IntegracaoBiblioteca());`

`FachadaMatricula` ficou idêntica à da etapa 4 (conferido por hash MD5 antes e depois).

## Como executar

```
javac -d out src/siga/*.java
java -cp out siga.Main
```
