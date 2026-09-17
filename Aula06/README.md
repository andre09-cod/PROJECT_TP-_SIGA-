# SIGA — Atividade de Padrões Criacionais (solução)

**Técnicas de Programação II (TP2) · Aula 6** — CST em Desenvolvimento de Software Multiplataforma · Fatec de Porto Ferreira

## Padrões aplicados

A solução do código fornecido aplica os três padrões pedidos:

1. **Abstract Factory** — famílias coerentes de objetos MySQL e PostgreSQL.
2. **Builder** — montagem legível de consultas com opções encadeáveis.
3. **Singleton** — ponto único e controlado de acesso a `AcessoDados`.

## Estrutura

```text
siga-criacionais/
├── src/
│   └── siga/
│       ├── AcessoDados.java
│       ├── Comando.java
│       ├── ComandoMySQL.java
│       ├── ComandoPostgreSQL.java
│       ├── Conexao.java
│       ├── ConexaoMySQL.java
│       ├── ConexaoPostgreSQL.java
│       ├── ConsultaBuilder.java
│       ├── FabricaBanco.java
│       ├── FabricaMySQL.java
│       ├── FabricaPostgreSQL.java
│       ├── Main.java
│       └── ObjetosAcessoDados.java
├── docs/
│   ├── ETAPAS.md
│   └── diagrama-padroes-criacionais.puml
└── README.md
```

## Como executar

JDK 17 ou superior:

```bash
javac -d bin src/siga/*.java
java -cp bin siga.Main
```

## Resultado esperado

```text
=== SIGA - Padrões Criacionais ===

Singleton: mesma instância? true

[MySQL] conexão aberta
[MySQL] executando: SELECT * FROM aluno

[PostgreSQL] conexão aberta
[PostgreSQL] executando: SELECT * FROM aluno

Consulta montada: SELECT * FROM aluno WHERE curso = 'DSM' AND ativo = 1 ORDER BY nome LIMIT 50
Timeout configurado: 30 segundos

Execução da consulta com a família MySQL:
[MySQL] executando: SELECT * FROM aluno WHERE curso = 'DSM' AND ativo = 1 ORDER BY nome LIMIT 50
```

## Evidências

O arquivo `docs/ETAPAS.md` explica o diagnóstico e as evidências de cada etapa. O arquivo `docs/diagrama-padroes-criacionais.puml` contém o diagrama UML da solução.

## Observação sobre a organização das classes

As implementações concretas que estavam reunidas em `ObjetosAcessoDados.java` foram separadas em arquivos próprios, deixando um arquivo por classe pública e facilitando a identificação das responsabilidades.
