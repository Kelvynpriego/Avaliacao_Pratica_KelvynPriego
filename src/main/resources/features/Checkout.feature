Feature: Fazer checkout
#  Fazer checkout com informações incompletas(Cenario negativo 03)
  Scenario: Fazer checkout com informações incompletas
    Given que o usuario tenha itens no carrinho
    When o usuario tentar finalizar a compra sem preencher todas as informações obrigatorias
    Then o usuario recebe uma mensagem de erro indicando que as informações estão incompletas
    And o usuario permanece na pagina de checkout para corrigir as informações

#  Fazer checkout com sucesso(Cenario positivo 04)
  Scenario: Fazer checkout com sucesso
    Given que o usuario tenha itens no carrinho
    When o usuario preencher todas as informações obrigatorias corretas e clicar em "Finalizar compra"
    Then o usuario deve ser redirecionado para a pagina de confirmação de compra
    And o usuario é redirecionado para a pagina de sucesso da compra
