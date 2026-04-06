Feature: Gerenciar carrinho
#  Adicionar item com sucesso(Cenario positivo 05)
  Scenario: Adicionar item com sucesso
    Given que o usuario esteja na pagina inicial
    When o usuario selecionar um item e clicar em "Adicionar ao carrinho"
    Then o item deve ser adicionado ao carrinho
    And o usuario pode remover o item do carrinho

  Scenario: Tentar finalizar a compra sem itens adicionados
#    Tentar finalizar a compra sem itens adicionados(Cenario negativo 06)
    Given que o usuario esteja na pagina do carrinho
    When o usuario clicar em "Finalizar compra" sem ter adicionado nenhum item ao carrinho
    Then o usuario deve receber uma mensagem de erro indicando que o carrinho está vazio