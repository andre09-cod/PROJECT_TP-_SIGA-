# SIGA — Aula 13: Padrões comportamentais

## O que foi implementado

- **Strategy:** `PoliticaDesconto` e quatro políticas (`DescontoBolsista`, `DescontoServidor`, `DescontoEgresso` e `SemDesconto`). A matrícula e o boleto recebem a mesma estratégia.
- **Observer:** `ObservadorMatricula`, `EventoMatricula` e `PublicadorMatricula`. As quatro reações iniciais são ouvintes independentes.
- **Isolamento de falhas:** o publicador captura a falha de um ouvinte e continua notificando os demais.
- **Quinta reação:** `NotificadorSms` é registrado no `Main` com uma única linha, sem alterar a `FachadaMatricula`.

## Regras de desconto

| Política | Desconto |
|---|---:|
| Bolsista | 50% |
| Servidor | 20% |
| Egresso | 10% |
| Sem desconto | 0% |

A seleção mantém a prioridade original: bolsista, servidor, egresso e, por último, sem desconto.

## Como executar

É necessário ter o JDK instalado. Abra o terminal na pasta `siga-comportamentais` e execute:

```bash
 javac -encoding UTF-8 -d out src/siga/*.java
 java -cp out siga.Main
```

No Windows também é possível executar os mesmos comandos pelo Prompt de Comando ou terminal do VS Code.

## Resultado esperado

Com valor-base de R$ 800,00, os valores são R$ 400,00 (bolsista), R$ 640,00 (servidor), R$ 720,00 (egresso) e R$ 800,00 (sem desconto). Matrícula e boleto apresentam valores iguais. Na turma lotada, o aviso da coordenação falha de propósito, mas auditoria e SMS ainda são executados.
