# Avaliacao_QA

Projeto de automacao de testes para o site [SauceDemo](https://www.saucedemo.com/), desenvolvido em Java com Selenium WebDriver e JUnit 4.

---

## O que voce precisa ter instalado

- Java JDK 11 ou superior
- Maven 3.8 ou superior
- Firefox (qualquer versao recente)
- IntelliJ IDEA

O projeto esta configurado para rodar no Firefox. No Mac, ele precisa estar instalado em `/Applications/Firefox.app`. Se estiver em outro caminho, ajuste em `baseTest.java` no metodo `iniciar()`.

---

## Estrutura do projeto

```
Avaliacao_QA/
├── evidencias/
├── src/
│   ├── main/
│   │   └── resources/
│   │       └── features/
│   │           ├── Carrinho.feature
│   │           ├── Checkout.feature
│   │           ├── Login.feature
│   │           └── paginaInicial.feature
│   └── test/
│       └── java/
│           ├── pagesObjects/
│           │   ├── basePO.java
│           │   ├── carrinhoPO.java
│           │   ├── checkoutPO.java
│           │   ├── loginPO.java
│           │   └── produtoPO.java
│           └── testes/
│               ├── baseTest.java
│               ├── carrinhoTest.java
│               ├── checkoutTest.java
│               ├── loginTest.java
│               └── produtoTest.java
└── pom.xml
```

A pasta `pagesObjects` contém o mapeamento de cada pagina do sistema. A pasta `testes` contém os casos de teste. As evidencias geradas apos cada execucao sao salvas na pasta `evidencias/`.

---

## Como executar os testes

### Pelo IntelliJ IDEA

Para rodar todos os testes de uma vez, clique com o botao direito na pasta `testes` e selecione "Run All Tests".

Para rodar um teste especifico, abra o arquivo desejado, clique no icone de play ao lado do metodo e selecione "Run".

### Pelo terminal

Todos os testes:

```bash
mvn test
```

Uma classe especifica:

```bash
mvn test -Dtest=carrinhoTest
```

Um metodo especifico:

```bash
mvn test -Dtest=carrinhoTest#TC_CART_01_DveAdicionarProdutoAoCarrinho
```

---

## Casos de teste

**Login**
- TC_AUT_01 — Login com usuario e senha corretos

**Carrinho**
- TC_CART_01 — Adicionar produto ao carrinho na pagina inicial
- TC_CART_03 — Checkout sem itens no carrinho (bug documentado — falha esperada)

**Checkout**
- TC_CHECK_01 — Realizar checkout completo com sucesso
- TC_CHECK_02C — Tentar avancar no checkout sem preencher o Zip/Postal Code

**Produto**
- TC_PROD_01 — Visualizar pagina de detalhes do produto

---

## Evidencias

Apos cada teste, um print da tela e salvo automaticamente na pasta `evidencias/` na raiz do projeto. O nome do arquivo inclui o nome do teste e o horario da execucao, facilitando a identificacao.

Exemplo:

```
TC_CART_01_DveAdicionarProdutoAoCarrinho_05-04-2026_17-48-55.png
```

---

## Credenciais

- Usuario: `standard_user`
- Senha: `secret_sauce`
- URL: https://www.saucedemo.com/

---

## Observacao sobre o TC_CART_03

Esse teste falha intencionalmente. O comportamento esperado seria o sistema bloquear o checkout com o carrinho vazio, mas o SauceDemo permite concluir o pedido mesmo sem nenhum item. O teste existe para documentar esse bug.
