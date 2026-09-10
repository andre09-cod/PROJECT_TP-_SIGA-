# SIGA - Atividade Factory (Aula 5)

Projeto refatorado conforme as etapas 1 a 4 do enunciado.

## Etapa 1 - Diagnóstico
O código inicial de `GerenciadorLogin` utilizava `if/else` e `new` diretamente para criar cada painel. Isso acoplava o gerenciador às classes concretas e exigia alteração do método a cada novo perfil, caracterizando violação do OCP.

## Etapa 2 - Simple Factory
Foi criada a classe `PainelFactory`, que centraliza a criação dos objetos `Painel`. A demonstração está em `MainSimpleFactory`.

## Etapa 3 - Factory Method
A criação foi refatorada para a hierarquia `CriadorPainel` + criadores concretos. Cada subclasse sobrescreve `criarPainel()`. `GerenciadorLogin` agora depende da abstração `CriadorPainel`.

## Etapa 4 - Novo perfil
Foi adicionado o perfil `SECRETARIA` com `PainelSecretaria` e `CriadorPainelSecretaria`. Os criadores existentes não foram alterados.

## Execução
O ponto de entrada da solução final é `siga.Main`.
