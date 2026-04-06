Feature: Abrir pagina detalhada do produto
#  Abrir pagina detalhada do produto com sucesso(Cenario positivo 03)
    Scenario: Abrir pagina detalhada do produto com sucesso
      Given que o usuario esteja na pagina inicial
      When o usuario clicar no produto
      Then o usuario deve ser redirecionado para a pagina detalhada do produto
      And o usuario pode visualizar as informações detalhadas do produto, como descrição, preço e adicionar ao carrinho

#   Abrir pagina detalhada do produto sem estoque(Cenario negativo 02)
#    Scenario: Abrir pagina detalhada do produto sem estoque
#        Given que o usuario esteja na pagina inicial
#        When o usuario clicar em um produto sem estoque
#        Then o usuario deve ser redirecionado para a pagina detalhada do produto
#        And o usuario deve visualizar uma mensagem indicando que o produto está indisponível e não pode ser adicionado ao carrinho