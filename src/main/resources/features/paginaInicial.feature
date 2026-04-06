Feature: Abrir pagina detalhada do produto
#  Abrir pagina detalhada do produto com sucesso(Cenario positivo 03)
    Scenario: Abrir pagina detalhada do produto com sucesso
      Given que o usuario esteja na pagina inicial
      When o usuario clicar no produto
      Then o usuario deve ser redirecionado para a pagina detalhada do produto
      And o usuario pode visualizar as informações detalhadas do produto, como descrição, preço e adicionar ao carrinho

  # Adicionar produto ao carrinho pela pagina detalhada(Cenario positivo)
  Scenario: Adicionar produto ao carrinho pela pagina detalhada
    Given que o usuario esteja na pagina detalhada do produto
    When o usuario clicar no botao "Add to cart"
    Then o produto deve ser adicionado ao carrinho
    And o icone do carrinho deve exibir a quantidade atualizada