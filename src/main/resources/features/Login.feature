Feature: Autenticar no site
#  Autenticar com sucesso(Cenario positivo 01)
  Scenario: Autenticar com sucesso
    Given que o usuario esteja na pagina de login
    When o usuario inserir informacoes validas
    Then o usuario deve ser redirecionado para a pagina inicial

#  Autenticar com senha incorreta(Cenario negativo 02)
  Scenario: Autenticar com senha incorreta
    Given que o usuario esteja na pagina de login
    When o usuario inserir uma senha incorreta
    Then o usuario deve receber uma mensagem de erro indicando que a senha esta incorreta
    And o usuario deve permanecer na pagina de login

#  Autenticar com email não cadastrado(Cenario negativo 01)
  Scenario: Autenticar com email não cadastrado
    Given que o usuario esteja na pagina de login
    When o usuario inserir um email nao cadastrado
    Then o usuario deve receber uma mensagem de erro indicando que o email nao esta cadastrado
    And o usuario deve permanecer na pagina de login