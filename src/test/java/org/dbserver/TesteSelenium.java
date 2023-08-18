package org.dbserver;

import org.dbserver.fluentPageObjects.pages.HomePage;
import org.dbserver.fluentPageObjects.pages.RegistroPage;
import org.dbserver.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TesteSelenium extends BaseTest {
    private final WebDriver driver = getDriver();

    private RegistroPage registroPage;
    private HomePage homePage;

    @Test
    @DisplayName("Cria a segunda conta")
    void fazCadastro(){
        this.homePage = new HomePage(driver)
                .clicaEmRegistrar();
        this.registroPage = new RegistroPage(driver)
                .paginaCadastro("aaa@aaa.com",
                        "aaa",
                        "123",
                        "123");
        this.homePage = new HomePage(driver)
                .clicaEmRegistrar();
        this.registroPage = new RegistroPage(driver)
                .limparCampos()
                .paginaCadastro("bbb@bbb.com",
                        "bbb",
                        "456",
                        "456");
        this.homePage = new HomePage(driver)
                .preencheAcesso("aaa@aaa.com",
                        "123");


    }



}
