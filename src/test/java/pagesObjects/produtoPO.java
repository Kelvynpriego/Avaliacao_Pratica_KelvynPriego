package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class produtoPO extends basePO {

    private By caminhoMochila = By.id("item_4_title_link");
    private By nomeProduto = By.cssSelector(".inventory_details_name");
    private By descricaoProduto = By.cssSelector(".inventory_details_desc");
    private By precoProduto = By.cssSelector(".inventory_details_price");
    private By buttonAdicionarToCart = By.id("add-to-cart");
    private By buttonVoltar = By.id("back-to-products");

    public produtoPO(WebDriver driver) {
        super(driver);
    }
    public void clicarNoProduto() {
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(caminhoMochila));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }
    public String obterNomeProduto(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nomeProduto)).getText();
    }
    public boolean exibirInformacoesProduto(){
        return driver.findElement(descricaoProduto).isDisplayed() &&
            driver.findElement(precoProduto).isDisplayed() &&
            driver.findElement(buttonAdicionarToCart).isDisplayed();
    }
    public boolean buttonVoltarExibido(){
        return driver.findElement(buttonVoltar).isDisplayed();
    }
}
