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
        espera = new WebDriverWait(driver, 3);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15),this);
    }

    @FindBy(xpath = "//button[text()='Registrar']")
    WebElement botaoRegistrar;
    @FindBy(name = "email")
    WebElement campoEmail;
    @FindBy(name = "name")
    WebElement campoNome;
    @FindBy(name = "password")
    WebElement campoSenha;
    @FindBy(name = "passwordConfirmation")
    WebElement campoConfirmarSenha;
    @FindBy(className = "styles__Input-sc-1pngcbh-1")
    WebElement botaoCriarContaComSaldo;
    @FindBy(xpath = "//button[text()='Acessar']")
    WebElement botaoCadastrar;
    @FindBy(className = "styles__Button-sc-8zteav-5")
    WebElement botaoFecharModal;


    public RegistroPage registrar(){
        this.botaoRegistrar.click();
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.className("card__register")));
        return new RegistroPage(driver);
    }

    public RegistroPage paginaCadastro(String email,
                                       String nome,
                                       String senha,
                                       String confirmacaoSenha){
        this.botaoRegistrar.click();
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.className("card__register")));
        this.campoEmail.sendKeys(email);
        this.campoNome.sendKeys(nome);
        this.campoSenha.sendKeys(senha);
        this.campoConfirmarSenha.sendKeys(confirmacaoSenha);
        this.botaoCriarContaComSaldo.click();
        this.botaoCadastrar.click();
        return new RegistroPage(driver);
    }

    public RegistroPage fecharModal(){
        this.botaoFecharModal.click();
        return new RegistroPage(driver);
    }



}
