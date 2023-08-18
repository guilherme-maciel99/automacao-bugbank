package org.dbserver.fluentPageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistroPage {
    WebDriver driver;
    WebDriverWait espera;

    public RegistroPage(WebDriver driver) {
        this.driver = driver;
        espera = new WebDriverWait(driver, 15);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15),this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")
    WebElement campoEmail;
    @FindBy(name = "name")
    WebElement campoNome;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")
    WebElement campoSenha;
    @FindBy(name = "passwordConfirmation")
    WebElement campoConfirmarSenha;
    @FindBy(className = "styles__Input-sc-1pngcbh-1")
    WebElement botaoCriarContaComSaldo;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")
    WebElement botaoCadastrar;
    @FindBy(id = "btnCloseModal")
    WebElement botaoFecharModal;

    public RegistroPage paginaCadastro(String email,
                                       String nome,
                                       String senha,
                                       String confirmacaoSenha){
        this.campoEmail.sendKeys(email);
        this.campoNome.sendKeys(nome);
        this.campoSenha.sendKeys(senha);
        this.campoConfirmarSenha.sendKeys(confirmacaoSenha);
        this.botaoCriarContaComSaldo.click();
        this.botaoCadastrar.click();
        espera.until(ExpectedConditions.elementToBeClickable(botaoFecharModal));
        this.botaoFecharModal.click();
        return new RegistroPage(driver);
    }
    public RegistroPage limparCampos(){
        espera.until(ExpectedConditions.elementToBeClickable(By.className("card__register")));
        this.campoEmail.clear();
        this.campoNome.clear();
        this.campoSenha.clear();
        this.campoConfirmarSenha.clear();
        return new RegistroPage(driver);
    }



}
