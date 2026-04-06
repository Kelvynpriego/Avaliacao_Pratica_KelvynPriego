package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class carrinhoPO extends basePO {
    /**
     * Construtor da classe basePO, para criação da fabrica de elementos(PageFactory)
     *
     * @param driver (Driver da pagina atual)
     */
    public carrinhoPO(WebDriver driver) {
        super(driver);
    }

    /**
     * Localizadores do TC_CART_01 - Adicionar produto ao carrinho
     **/
    private By botaoAdicionarMochila = By.id("add-to-cart-sauce-labs-backpack");
    private By botaoRemoverMochila = By.id("remove-sauce-labs-backpack");
    private By iconCarrinho = By.className("shopping_cart_link");
    private By badgeCarrinho = By.className("shopping_cart_badge");
    private By nomeProdutoNoCarrinho = By.className("inventory_item_name");

    /**
     * Localizadores do TC_CART_03 - Fazer Checkout sem itens
     **/
    private By botaoCheckout = By.id("checkout");
    private By campoFirstName = By.id("first-name");
    private By campoLastName = By.id("last-name");
    private By campoPostalCode = By.id("postal-code");
    private By botaoContinue = By.id("continue");
    private By botaoFinish = By.id("finish");
    private By tituloOverview = By.className("title");
    private By mensagemConfirmacao = By.className("complete-header");


    /**
     * Metodos TC_CART_01
     **/
    public void clicarAdicionarAoCarrinho() {
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(botaoAdicionarMochila));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    public boolean botaoRemoverExibido() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(botaoRemoverMochila)).isDisplayed();
    }

    public String obterQuantidadeBadge() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(badgeCarrinho)).getText();
    }

    public void clicarIconeCarrinho() {
        driver.findElement(iconCarrinho).click();
    }

    public boolean produtoListadoNoCarrinho() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nomeProdutoNoCarrinho)).isDisplayed();
    }

    public boolean estarNaPaginaCarrinho() {
        return driver.getCurrentUrl().contains("/cart.html");
    }


    /**
     * Metodos TC_CART_03
     **/
    public void clicarCheckout() {
        driver.findElement(botaoCheckout).click();
    }

    public void preencherDadosCheckout(String nome, String sobremome, String cep) {
        driver.findElement(campoFirstName).sendKeys(nome);
        driver.findElement(campoLastName).sendKeys(sobremome);
        driver.findElement(campoPostalCode).sendKeys(cep);
    }

    public void clicarContinue() {
        driver.findElement(botaoContinue).click();
    }

    public void clicarFinish() {
        driver.findElement(botaoFinish).click();
    }

    public boolean estarEmCheckoutOverview() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tituloOverview))
                .getText().contains("Checkout: Overview");
    }

    public boolean mensagemConfirmacao() {
        return driver.findElement(mensagemConfirmacao).isDisplayed();
    }
}
