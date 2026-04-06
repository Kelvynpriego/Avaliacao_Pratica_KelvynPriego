# Avaliacao_QA — Guia de Execução dos Testes

## Requisitos
Java JDK 17 ou superior
Maven 3.8 ou superior
Navegador Fireforx qualquer versão
IntelliJ IDEA qualquer versão

## Estrutura do Projeto
Avaliacao_QA/
├── evidencias/              # Prints gerados automaticamente após cada teste
├── src/
│   └── test/
│       └── java/
│           ├── pagesObjects/    # Page Objects (mapeamento das páginas)
│           │   ├── basePO.java
│           │   ├── carrinhoPO.java
│           │   ├── checkoutPO.java
│           │   ├── loginPO.java
│           │   └── produtoPO.java
│           └── testes/          # Classes de teste
│               ├── baseTest.java
│               ├── carrinhoTest.java
│               ├── checkoutTest.java
│               ├── loginTest.java
│               └── produtoTest.java
└── pom.xml

Como Executar os Testes
Opção 1 — Pelo IntelliJ IDEA (recomendado)
Executar todos os testes:

Abra o projeto no IntelliJ IDEA
No painel esquerdo, clique com o botão direito na pasta testes
Selecione "Run 'All Tests'"
Acompanhe os resultados no painel inferior

Executar um teste específico:

Abra o arquivo de teste desejado (ex: carrinhoTest.java)
Clique no ícone verde ao lado do método de teste
Selecione "Run"