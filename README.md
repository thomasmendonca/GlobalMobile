# Integrantes Solution Devvelopers
- Gabriel Augusto Fernandes - RM: 98986
- Kauê Fernandes Braz - RM: 97768
- Mariana Trentino Albano - RM: 551154
- Matheus Dantas de Sousa - RM: 98406
- Thomas Nícolas de Melo Mendonça - RM: 99832

# Aplicativo Tilapia Mobile

## Visão Geral

Este documento fornece uma visão geral do Aplicativo Tilapia Mobile, descrevendo o propósito do sistema, seus principais componentes e como configurá-lo.

## Propósito

O Aplicativo Tilapia Mobile foi projetado para buscar e exibir uma lista de dados de Tilápia de um servidor. O aplicativo utiliza Retrofit para operações de rede, recuperando dados no formato JSON e exibindo-os em um RecyclerView.

## Endpoints da API

- **GET /tilapiaMobile**: Retorna uma lista de Tilápias no formato JSON.

## Instruções de Configuração

1. **Pré-requisitos**: Certifique-se de ter o Android Studio instalado.
2. **Clone o Repositório**: Clone o repositório do projeto para sua máquina local.
3. **Abra o Projeto**: Abra o projeto no Android Studio.
4. **Atualize a URL Base**: Certifique-se de que a `BASE_URL` em `RetrofitInstance` aponte para o endereço correto do servidor.
5. **Execute o Aplicativo**: Execute o aplicativo em um emulador ou dispositivo físico.

## Conclusão

Este README fornece uma visão geral e instruções de configuração para o Aplicativo Tilapia Mobile. O aplicativo busca dados de um servidor e os exibe em um RecyclerView usando Retrofit para operações de rede. Para mais detalhes, consulte os comentários no código-fonte.
