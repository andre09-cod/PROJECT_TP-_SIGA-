# Evidências das etapas — SIGA / Padrões Criacionais

## Etapa 1 — Diagnóstico

O código inicial apresentava dois problemas principais no desenho da criação dos objetos.

### 1.1 Mistura de fornecedores

No método `conectar`, o programa criava a conexão e o comando separadamente dentro de condicionais. Isso permitia que, por alteração acidental do código, fosse criada uma `ConexaoMySQL` junto com um `ComandoPostgreSQL`.

O problema não era apenas a existência de `new`, mas a falta de uma estrutura que tratasse conexão e comando como uma família de produtos.

### 1.2 Construtor/método telescópico

O método inicial `montarConsulta` recebia vários parâmetros posicionais:

`tabela, filtro, ordenacao, limite, offset, timeoutSegundos, somenteAtivos`.

A chamada ficava difícil de ler porque números e booleanos não deixavam claro o significado de cada argumento. Também havia risco de trocar a ordem dos valores.

### 1.3 Instância não controlada

O código inicial permitia `new AcessoDados()` em qualquer ponto do programa. A solução da atividade pede um único ponto de acesso, portanto foi aplicado Singleton.

---

## Etapa 2 — Abstract Factory

Foram criados:

- `FabricaBanco` — fábrica abstrata;
- `FabricaMySQL` — fábrica concreta MySQL;
- `FabricaPostgreSQL` — fábrica concreta PostgreSQL;
- `ConexaoMySQL` e `ComandoMySQL` — produtos concretos MySQL;
- `ConexaoPostgreSQL` e `ComandoPostgreSQL` — produtos concretos PostgreSQL.

A classe `AcessoDados` recebe uma `FabricaBanco` e solicita os dois produtos à mesma fábrica. Dessa forma, a família é criada de maneira coerente.

**Evidência esperada:** ao executar `Main`, aparecem mensagens de conexão e comando identificadas pelo mesmo fornecedor.

---

## Etapa 3 — Builder

Foi criada a classe `ConsultaBuilder`.

A configuração agora pode ser lida como uma sequência de passos:

```text
ConsultaBuilder.paraTabela("aluno")
    .comFiltro("curso = 'DSM'")
    .somenteAtivos()
    .comOrdenacao("nome")
    .comLimite(50)
    .comOffset(0)
    .comTimeout(30)
    .construir();
```

O método `construir()` produz a consulta final. Os métodos são nomeados e encadeáveis, eliminando a chamada telescópica.

**Evidência esperada:** a consulta exibida no console é legível e contém os opcionais escolhidos.

---

## Etapa 4 — Singleton

`AcessoDados` foi transformado em Singleton:

- classe `final`;
- atributo estático privado `instancia`;
- construtor privado;
- método público `getInstancia()`;
- acesso sincronizado à criação da instância.

No `Main`, duas chamadas de `getInstancia()` são comparadas com `==`, comprovando que apontam para o mesmo objeto.

**Evidência esperada:** `Singleton: mesma instância? true`.

---

## Etapa 5 — Diagrama de classes

O arquivo `diagrama-padroes-criacionais.puml` representa as interfaces, fábricas concretas, produtos concretos, Builder e Singleton.

A relação entre os padrões fica assim:

- **Abstract Factory:** `FabricaBanco` cria `Conexao` e `Comando` de uma mesma família.
- **Builder:** `ConsultaBuilder` constrói a consulta passo a passo.
- **Singleton:** `AcessoDados` possui uma única instância controlada.
