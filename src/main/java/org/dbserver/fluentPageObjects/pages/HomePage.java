package org.dbserver.fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15),this);
    }

    @FindBy(name = "email")
    WebElement campoEmail;
    @FindBy(name = "password")
    WebElement campoSenha;
    @FindBy(className = "style__ContainerButton-sc-1wsixal-0 otUnI button__child")
    WebElement botaoAcessar;
    @FindBy(id = "textName")
    WebElement textoNome;

    public HomePage paginaAcesso(String email,String senha){
        this.campoEmail.sendKeys(email);
        this.campoSenha.sendKeys(senha);
        this.botaoAcessar.click();
        return new HomePage(driver);
    }

    public String getTextoNome(){
        return textoNome.getText();
    }

}
