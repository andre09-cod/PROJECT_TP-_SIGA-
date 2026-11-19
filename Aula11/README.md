# SIGA — Aula 11: Decorator e Composite (atividade respondida)

## Etapa 1 — Contagem de subclasses de relatório

**Subclasses existentes** (todas estendem `RelatorioDeAlunos`):

1. `RelatorioComCabecalho`
2. `RelatorioComNumeracao`
3. `RelatorioComCabecalhoENumeracao`
4. `RelatorioComCabecalhoENumeracaoEMarcaDagua`

Total: **4 subclasses** para **3 características opcionais** (cabeçalho, numeração, marca d'água).

**Raciocínio (2 elevado a n):** cada característica opcional pode estar presente ou ausente,
então n características independentes geram 2^n combinações. Uma delas é a combinação vazia
(o próprio `RelatorioDeAlunos`), que não precisa de subclasse.

| Características (n) | Combinações (2^n) | Subclasses necessárias (2^n − 1) |
|---------------------|-------------------|----------------------------------|
| 3                   | 8                 | 7 (existem só 4; faltam 3)       |
| **4** (ex.: + assinatura digital) | **16** | **15**                       |

Ao acrescentar uma **quarta característica**, seriam necessárias **2^4 = 16 classes de relatório
(15 subclasses + a base)**: o número dobra a cada característica nova. Além da explosão de
classes, o texto do cabeçalho e a lógica de numeração ficam copiados em várias delas.

## Etapa 2 — DecoratorRelatorio e decoradores

Criados `DecoratorRelatorio` (abstrato, implementa `Relatorio` e recebe um `Relatorio`),
`CabecalhoDecorator`, `NumeracaoDecorator` e `MarcaDaguaDecorator`.

As **4 subclasses** foram removidas e substituídas por **3 classes**, cada comportamento
escrito **uma única vez** (o texto do cabeçalho agora existe só em `CabecalhoDecorator`).

## Etapa 3 — Pilhas de decoradores no cliente (`Main`)

Quatro saídas distintas a partir da mesma classe base `RelatorioDeAlunos`:

- sem decoradores
- `Cabecalho(Numeracao(Alunos))`
- `MarcaDagua(Cabecalho(Numeracao(Alunos)))`
- `MarcaDagua(Alunos)` — combinação que nunca existiu como subclasse

A ordem importa: o cabeçalho fica por fora da numeração para não ser numerado.

## Etapa 4 — Composite

`ItemCurricular` (`getNome`, `getCargaHoraria`, `imprimir(nivel)`) é a interface comum.
`Disciplina` é a **folha** e `Modulo` é o **composto**, com `List<ItemCurricular>`.
`GradeCurricular` e seus `instanceof` foram eliminados: a recursão ficou dentro de `Modulo`.
Carga horária total calculada com `item.getCargaHoraria()`, **sem nenhum `instanceof`**: 340h.

## Etapa 5 — Submódulo de terceiro nível

Acrescentado o módulo "Optativas do 2o semestre" (2 disciplinas de 40h) dentro do
"2o semestre". Estrutura de **três níveis de módulo** impressa com o recuo correto e
carga total atualizada para 420h. As linhas do cliente que imprimem e somam
(`item.imprimir(1)` e `item.getCargaHoraria()`) **não mudaram**; só a montagem da árvore cresceu.

## Como executar

```
javac -d out src/siga/*.java
java -cp out siga.Main
```
