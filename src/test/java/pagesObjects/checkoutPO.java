package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutPO extends basePO {

    /**
     * Deixei os caminhos todos prontos para o selenium.
     */

    private By iconeCarrinho = By.className("shopping_cart_link");
    private By botaoCheckout = By.id("checkout");
    private By campoFirstName = By.id("first-name");
    private By campoLastName = By.id("last-name");
    private By campoPostalCode = By.id("postal-code");
    private By botaoContinue = By.id("continue");
    private By botaoFinish = By.id("finish");
    private By botaoCancel = By.id("cancel");
    private By botaoBackHome = By.id("back-to-products");
    private By botaoAdicionarAoCarrinho = By.id("add-to-cart-sauce-labs-bike-light");
    private By mensagemErro = By.cssSelector(".error-message-container.error");


    public checkoutPO(WebDriver driver) {
        super(driver);
    }

    public void clicarBotaoCarrinho() {
        driver.findElement(iconeCarrinho).click();
    }

    public void clicarBotaoCheckout() {
        driver.findElement(botaoCheckout).click();
    }

    public void preencherCampoFirstName(String texto) {
        driver.findElement(campoFirstName).sendKeys(texto);
    }

    public void preencherCampoLastName(String texto) {
        driver.findElement(campoLastName).sendKeys(texto);
    }

    public void preencherCampoPostalCode(String texto) {
        driver.findElement(campoPostalCode).sendKeys(texto);
    }

    public void clicarBotaoContinue() {
        driver.findElement(botaoContinue).click();
    }

    public void clicarBotaoFinish() {
        driver.findElement(botaoFinish).click();
    }

    public String obterMensagemErro() {
        return driver.findElement(mensagemErro).getText();
    }

    public boolean estaNaTelaCheckoutInfo() {
        return driver.getCurrentUrl().contains("checkout-step-one.html");
    }

    public void adicionarProdutoAoCarrinho() {
        driver.findElement(botaoAdicionarAoCarrinho).click();
    }
}