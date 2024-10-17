# Currency Converter

Uma aplicação simples de linha de comando para conversão de moedas utilizando a ExchangeRate-API. A aplicação permite ao usuário converter pares de moedas predefinidos e visualizar a taxa de conversão e o resultado de maneira clara e formatada.

## Funcionalidades

- Converter moedas entre USD, ARS, BRL e COP.
- Exibir taxas de câmbio atuais e o valor equivalente na moeda de destino.
- Sistema de menu intuitivo para selecionar as opções de conversão.
- Busca dados em tempo real da ExchangeRate-API.

## Tecnologias Utilizadas

- **Java 21**.
- **ExchangeRate-API**: Para obter taxas de câmbio em tempo real.
- **Gson**: Para fazer o parsing da resposta JSON da API.
- **HttpClient**: Para lidar com requisições e respostas HTTP.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java 21**

Você também precisará se inscrever e obter uma chave de API no [ExchangeRate-API](https://www.exchangerate-api.com/).

## Iniciando o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/systemnegro/currency-converter.git


## 2. Configurar a chave de API

Para utilizar a API de conversão de moedas, é necessário configurar a chave de API:

1. No código-fonte do projeto, abra o arquivo `ExchangeRateApiClient.java`.
2. Substitua o valor `API_KEY` pela chave da API que você obteve ao se cadastrar.

Exemplo:
```java
String apiKey = "SUA_CHAVE_DE_API_AQUI";

