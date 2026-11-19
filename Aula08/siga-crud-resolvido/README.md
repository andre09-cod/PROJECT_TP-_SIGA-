# SIGA — CRUD completo e Etapa 1

Projeto resolvido com base no arquivo inicial e nas etapas da atividade.

## O que foi implementado

1. **DAO / CRUD:** inserir, buscar, listar, atualizar e remover.
2. **Duplicidade:** o DAO impede duas matrículas iguais e informa o problema.
3. **Camada de serviço:** `cadastrar`, `listar`, `consultar`, `alterar` e `excluir`.
4. **Validação centralizada:** o método privado `validar(Aluno)` verifica nome, matrícula e média entre 0 e 10. A regra fica somente no serviço.
5. **Correção dos três deslizes:**
   - `listarTodos()` devolve uma nova lista (cópia defensiva);
   - `remover()` informa quando a matrícula não existe;
   - a apresentação não repete a validação da média.
6. **Apresentação:** captura exceções e mostra mensagens específicas; não há `catch` vazio.
7. **Demonstração:** `Main` executa exemplos de cadastro, consulta, atualização, exclusão e situações inválidas.

## Estrutura

```text
siga-crud-resolvido/
├── README.md
└── src/
    └── siga/
        ├── Aluno.java
        ├── AlunoDAO.java
        ├── AlunoDAOMemoria.java
        ├── ServicoAluno.java
        └── Main.java
```

## Como executar no VS Code / terminal

É necessário ter o JDK instalado. Na pasta `siga-crud-resolvido`, execute:

```bash
javac -d bin src/siga/*.java
java -cp bin siga.Main
```

No PowerShell do Windows, os mesmos comandos funcionam. Se o terminal não estiver na pasta do projeto, entre nela primeiro com `cd`.

## Responsabilidade de cada camada

- **Apresentação (`Main`)**: inicia as operações e transforma exceções em mensagens para o usuário.
- **Serviço (`ServicoAluno`)**: aplica as regras de negócio e valida os dados.
- **DAO (`AlunoDAO` / `AlunoDAOMemoria`)**: armazena e recupera os dados.

## Sugestões de commits

```text
Implementa operações CRUD no DAO de alunos
Adiciona validações e operações na camada de serviço
Corrige encapsulamento, exclusão e validação duplicada
Documenta execução e organização do projeto
```

> Observação: o README do material inicial informa que o uso de IA é proibido nesta atividade. Use este material para estudar e confira as regras com o professor antes de entregar. Entenda o código e faça as adaptações que forem necessárias para demonstrar sua autoria e aprendizado.
