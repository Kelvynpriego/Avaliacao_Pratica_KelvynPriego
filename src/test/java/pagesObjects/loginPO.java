package pagesObjects;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class loginPO extends basePO {

    /**
     * Construtor da classe basePO, para criação da fabrica de elementos(PageFactory)
     *
     * @param driver (Driver da pagina atual)
     */
    public loginPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement inputName;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(id = "login-button")
    private WebElement buttonLogin;


    public void executaAcaoDeLogar(String username, String password) {
        escrever((WebElement) inputName, username);
        escrever((WebElement) inputPassword, password);
        buttonLogin.click();
    }
}
