package org.dbserver;

import org.dbserver.fluentPageObjects.pages.HomePage;
import org.dbserver.fluentPageObjects.pages.RegistroPage;
import org.dbserver.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteSelenium extends BaseTest {
    private final WebDriver driver = getDriver();

    private RegistroPage registroPage;
    private HomePage homePage;

    @BeforeEach
    void init() {
        this.registroPage = new RegistroPage(driver)
                .registrar()
                .paginaCadastro("aaa@aaa.com",
                        "aaa",
                        "123",
                        "123")
                .fecharModal();
        this.registroPage = new RegistroPage(driver)
                .registrar()
                .paginaCadastro("bbb@bbb.com",
                        "bbb",
                        "456",
                        "456")
                .fecharModal();
    }
    @Test
    @DisplayName("Faz login na primeira conta")
    void fazLoginPrimeiraConta(){
        this.homePage = new HomePage(driver)
                .paginaAcesso("aaa@aaa.com",
                        "123");
        assertEquals("Olá aaa,", homePage.getTextoNome());

    }



}
