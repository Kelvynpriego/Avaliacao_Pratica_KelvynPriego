package pagesObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Classe para criação de novas PagesObjects
 * Todas as pages devem ser herdadas dessa classe
 */
public class basePO {
    /**
     * Driver ue será usada para pages
     */
    protected WebDriver driver;
    /**
     * WebDriverWait para esperas explícitas
     */
    protected WebDriverWait wait;

    /**
     * Construtor da classe basePO, para criação da fabrica de elementos(PageFactory)
     * @param driver (Driver da pagina atual)
     */
    public basePO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }
    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
}
