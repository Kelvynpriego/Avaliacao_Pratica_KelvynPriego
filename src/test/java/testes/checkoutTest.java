package testes;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pagesObjects.checkoutPO;
import pagesObjects.loginPO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class checkoutTest extends baseTest {
    private checkoutPO checkoutPage;
    private loginPO loginPage;
    private checkoutPO mensagemErro;

    @Before
    public void setupTest() {
        loginPage = new loginPO(driver);
        checkoutPage = new checkoutPO(driver);

        driver.get("https://www.saucedemo.com/");

        loginPage.executaAcaoDeLogar("standard_user", "secret_sauce");

        checkoutPage.adicionarProdutoAoCarrinho();
    }

    @Test
    public void TC_CHECK_01_DeveSerPossivelRealizarCheckout() {
        checkoutPage.clicarBotaoCarrinho();
        checkoutPage.clicarBotaoCheckout();

        checkoutPage.preencherCampoFirstName("Lelex");
        checkoutPage.preencherCampoLastName("Max");
        checkoutPage.preencherCampoPostalCode("40028922");

        checkoutPage.clicarBotaoContinue();
        checkoutPage.clicarBotaoFinish();

        System.out.println("Teste TC_CHECK_01_DeveSerPossivelRealizarCheckout realizado com sucesso");
    }

    @Test
    public void TC_CHECK_O2C_NaoDeveSerPossivelRealizarCheckoutSemPreencherCamposObrigatorios() {
        checkoutPage.clicarBotaoCarrinho();
        checkoutPage.clicarBotaoCheckout();
        checkoutPage.preencherCampoFirstName("Lelex");
        checkoutPage.preencherCampoLastName("Max");
        /**O campo Zip/Postal Code é obrigatorio, mas nao vou preencher nesse caso de teste!**/

        checkoutPage.clicarBotaoContinue();
        String mensagemErro = checkoutPage.obterMensagemErro();
        assertEquals("Error: Postal Code is required", mensagemErro);
        assertTrue(checkoutPage.estaNaTelaCheckoutInfo());

        System.out.println("Teste TC_CHECK_O2C_NaoDeveSerPossivelRealizarCheckoutSemPreencherCamposObrigatorios realizado com sucesso");
    }
}