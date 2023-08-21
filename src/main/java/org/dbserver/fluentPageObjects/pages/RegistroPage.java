package org.dbserver.fluentPageObjects.pages;

import org.dbserver.utils.ListaContas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class RegistroPage {
    WebDriver driver;
    WebDriverWait espera;

    ListaContas listaContas;

    public RegistroPage(WebDriver driver, ListaContas listaContas) {
        this.driver = driver;
        this.listaContas = listaContas;
        espera = new WebDriverWait(driver, 30);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")
    WebElement campoEmail;
    @FindBy(name = "name")
    WebElement campoNome;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")
    WebElement campoSenha;
    @FindBy(name = "passwordConfirmation")
    WebElement campoConfirmarSenha;
    @FindBy(id = "toggleAddBalance")
    WebElement botaoCriarContaComSaldo;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")
    WebElement botaoCadastrar;
    @FindBy(id = "btnCloseModal")
    WebElement botaoFecharModal;
    @FindBy(id = "modalText")
    WebElement textoNumeroConta;


    public RegistroPage paginaCadastro(String email,
                                       String nome,
                                       String senha,
                                       String confirmacaoSenha,
                                       boolean saldoAtivado){
        espera.until(ExpectedConditions.elementToBeClickable(By.className("card__register")));
        this.campoEmail.sendKeys(email);
        this.campoNome.sendKeys(nome);
        this.campoSenha.sendKeys(senha);
        this.campoConfirmarSenha.sendKeys(confirmacaoSenha);
        if(!saldoAtivado){
            this.botaoCriarContaComSaldo.click();
        }
        this.botaoCadastrar.click();
        return new RegistroPage(driver, listaContas);
    }

    public RegistroPage fecharModal(){
        espera.until(ExpectedConditions.elementToBeClickable(botaoFecharModal));
        this.textoNumeroConta.getText();
        listaContas.adicionarNumeroConta(this.textoNumeroConta.getText());
        this.botaoFecharModal.click();
        return new RegistroPage(driver, listaContas);
    }
    public RegistroPage limparCampos(){
        this.campoEmail.clear();
        this.campoNome.clear();
        this.campoSenha.clear();
        this.campoConfirmarSenha.clear();
        return new RegistroPage(driver, listaContas);
    }
}
