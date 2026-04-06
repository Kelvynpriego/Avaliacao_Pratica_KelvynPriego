package testes;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe base que serve de herança para todas as classes de teste!!
 */

public class baseTest {
    /**
     * Driver do navegador da pagina atual
     **/
    protected WebDriver driver;
    /**
     * Caminho base da URL do sistema a ser testado
     **/

    /**
     * Captura o nome do teste em execução
     **/
    @Rule
    public TestName nomeDoTeste = new TestName();
    /**
     * Caminho base da URL do sistema a ser testado
     **/
    private static final String URLBASE = "https://www.saucedemo.com/";

    /**
     * Metodo que inicia antes de qualquer classe de teste
     **/
    @Before
    public void iniciar() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");

        driver = new FirefoxDriver(options);
        driver.get(URLBASE);
        driver.manage().window().maximize();
    }

    /**
     * Metodo para finalizar o driver do navegador depois de qualquer classe de teste
     **/
    @After
    public void finalizar() {
        tirarprint();

        if (driver != null) {
            driver.quit();
        }
    }

    private void tirarprint() {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

            String nomeArquivo = nomeDoTeste.getMethodName() + "_" + timestamp + ".png";

            File destino = new File("evidencias/" + nomeArquivo);
            FileUtils.copyFile(screenshot, destino);

            System.out.println("Print salvo: " + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao salvar print: " + e.getMessage());
        }
    }
}