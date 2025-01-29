****Teste de Automacao com Selenium****

Descricao

Este projeto utiliza Selenium WebDriver com Java para realizar testes automatizados em um ambiente de treinamento. Os testes interagem com diversos elementos da pagina, como campos de texto, botoes, seletores, radios e checkboxes, garantindo a funcionalidade correta da aplicacao.

Tecnologias Utilizadas

Java

Selenium WebDriver

JUnit

FirefoxDriver

*Estrutura do Projeto*

project-root/
|-- src/
|   |-- main/
|   |   |-- java/
|   |-- test/
|   |   |-- java/
|   |   |   |-- com/example/TesteCampoTreinamento.java
|   |   |   |-- com/example/DSL.java
|-- resources/
|   |-- componentes.html
|-- README.md

Pre-requisitos

Antes de executar os testes, certifique-se de ter instalado:

Java (JDK 8 ou superior)

GeckoDriver (para Firefox)

Selenium WebDriver

JUnit

Configuracao e Execucao

Clone este reposito:

git clone https://github.com/seu-repositorio.git

Configure o GeckoDriver no PATH do sistema.

Execute os testes com JUnit no seu ambiente de desenvolvimento (por exemplo, Eclipse ou IntelliJ).

Funcionalidades Testadas

Os testes verificam a interacao com os seguintes elementos:

Campos de texto: Testa escrita e validacao de valores inseridos.

TextArea: Insere e verifica texto inserido.

Radio Buttons: Seleciona e verifica selecao.

CheckBoxes: Seleciona e verifica estado.

Dropdowns: Seleciona valores simples e multiplos.

Botoes: Clique e validacao de resposta.

Links: Clique e verificacao de navegacao.

JavaScript: Manipulacao direta de elementos via JS.

Exemplo de Codigo
