package org.dbserver.fluentPageObjects.pages;

import org.dbserver.utils.ListaContas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait espera;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        espera = new WebDriverWait(driver, 15);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15),this);
    }

    @FindBy(name = "email")
    WebElement campoEmail;
    @FindBy(name = "password")
    WebElement campoSenha;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]")
    WebElement botaoAcessar;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")
    WebElement botaoRegistrar;


    public HomePage preencheAcesso(String email,String senha){
        this.campoEmail.sendKeys(email);
        this.campoSenha.sendKeys(senha);
        this.botaoAcessar.click();
        return new HomePage(driver);
    }

    public HomePage clicaEmRegistrar(){
        espera.until(ExpectedConditions.elementToBeClickable(By.className("card__register")));
        this.botaoRegistrar.click();
        return new HomePage(driver);
    }

}
