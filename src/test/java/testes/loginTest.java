package testes;

import org.junit.Before;
import org.junit.Test;
import pagesObjects.loginPO;


public class loginTest extends baseTest {
    private loginPO loginPage;

    @Before
    public void inicializar() {
        loginPage = new loginPO(driver);
    }

    @Test
    public void TC_AUT_01_DeveLogarComUserESenhaCorretos() {
        loginPage.executaAcaoDeLogar("standard_user", "secret_sauce");
        System.out.println("Teste TC_AUT_01_DeveLogarComUserESenhaCorretos realizado com sucesso");
    }
}
