package testes;

import org.junit.Before;
import org.junit.Test;
import pagesObjects.carrinhoPO;
import pagesObjects.loginPO;

import static org.junit.Assert.*;

public class carrinhoTest extends baseTest {
    private carrinhoPO carrinho;
    private loginPO login;

    @Before
    public void setupLogin() {
        login = new loginPO(driver);
        carrinho = new carrinhoPO(driver);

        driver.get("https://www.saucedemo.com/");
        login.executaAcaoDeLogar("standard_user", "secret_sauce");
        System.out.println("URL após login: " + driver.getCurrentUrl());
    }

    /**
     * Caso de teste TC_CART_01
     **/

    @Test
    public void TC_CART_01_DveAdicionarProdutoAoCarrinho() {
        carrinho.clicarAdicionarAoCarrinho();

        assertTrue("Botão Remove deveria estar visivel", carrinho.botaoRemoverExibido());
        assertEquals("Badge do carrinho deveria exibir 1", "1", carrinho.obterQuantidadeBadge());
        assertTrue("Usuario deveria permanecer na pagina inicial",
                driver.getCurrentUrl().contains("/inventory.html"));

        carrinho.clicarIconeCarrinho();

        assertTrue("Deveria estar na pagina do carrinho", carrinho.estarNaPaginaCarrinho());
        assertTrue("Produto deveria estar listado no carrinho", carrinho.produtoListadoNoCarrinho());

        System.out.println("Teste TC_CART_01_DveAdicionarProdutoAoCarrinho realizado com sucesso");
    }

    /**
     * Caso de teste TC_CART_03
     **/
    @Test
    public void TC_CART_03_FazerCheckoutSemItens() {
        carrinho.clicarIconeCarrinho();
        assertTrue("Deveria estar na pagina do carrinho",
                carrinho.estarNaPaginaCarrinho());

        carrinho.clicarCheckout();
        carrinho.preencherDadosCheckout("Raiden", "Mei", "123456");
        carrinho.clicarContinue();
        assertTrue("Sistema não deveria avançar para o Overview sem itens",
                carrinho.estarEmCheckoutOverview());
        carrinho.clicarFinish();

        assertFalse("O sistema concluiu pedido sem itens ao carrinho, possivel BUG?",
                carrinho.mensagemConfirmacao());

        System.out.println("Teste TC_CART_03 executado");
    }
}
