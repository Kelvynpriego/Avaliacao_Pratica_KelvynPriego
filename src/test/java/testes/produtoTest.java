package testes;

import org.junit.Assert;
import org.junit.Test;
import pagesObjects.loginPO;
import pagesObjects.produtoPO;

public class produtoTest extends baseTest{

    @Test
    public void TC_PROD_01_deveSerPossivelVerPaginaDetalhada(){
        loginPO loginPO = new loginPO(driver);
        produtoPO produto = new produtoPO(driver);

        loginPO.executaAcaoDeLogar("standard_user", "secret_sauce");

        produto.clicarNoProduto();

        Assert.assertEquals(produto.obterNomeProduto(), "Sauce Labs Backpack");
        Assert.assertEquals(produto.exibirInformacoesProduto(), true);

        Assert.assertTrue(produto.buttonVoltarExibido());
    }
}
