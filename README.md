# Avaliacao_QA

Projeto de automação de testes para o site [SauceDemo](https://www.saucedemo.com/), desenvolvido em Java com Selenium WebDriver e JUnit 4.

---

## O que você precisa ter instalado

- Java JDK 11 ou superior
- Maven 3.8 ou superior
- Firefox (qualquer versão recente)
- IntelliJ IDEA

O projeto está configurado para rodar no Firefox. No Mac, ele precisa estar instalado em `/Applications/Firefox.app`. Se estiver em outro caminho, ajuste em `baseTest.java` no método `iniciar()`.

---

## Como executar os testes

### Pelo IntelliJ IDEA

Para rodar todos os testes de uma vez, clique com o botão direito na pasta `testes` e selecione "Run All Tests".

Para rodar um teste específico, abra o arquivo desejado, clique no ícone de play ao lado do método e selecione "Run".

### Pelo terminal

Todos os testes:
```bash
mvn test
```

Uma classe específica:
```bash
mvn test -Dtest=carrinhoTest
```

Um método específico:
```bash
mvn test -Dtest=carrinhoTest#TC_CART_01_DveAdicionarProdutoAoCarrinho
```

---

## Casos de teste

**Login**
- TC_AUT_01 — Login com usuário e senha corretos

**Carrinho**
- TC_CART_01 — Adicionar produto ao carrinho na página inicial
- TC_CART_03 — Checkout sem itens no carrinho (bug documentado — falha esperada)

**Checkout**
- TC_CHECK_01 — Realizar checkout completo com sucesso
- TC_CHECK_02C — Tentar avançar no checkout sem preencher o Zip/Postal Code

**Produto**
- TC_PROD_01 — Visualizar página de detalhes do produto

---

## Evidências

Após cada teste, um print da tela é salvo automaticamente na pasta `evidencias/` na raiz do projeto. O nome do arquivo inclui o nome do teste e o horário da execução, facilitando a identificação.

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
