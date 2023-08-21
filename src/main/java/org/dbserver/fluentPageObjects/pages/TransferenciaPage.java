package org.dbserver.fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferenciaPage {

    WebDriver driver;
    WebDriverWait espera;

    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
        espera = new WebDriverWait(driver, 15);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15),this);
    }

    @FindBy(id = "btn-TRANSFERÊNCIA")
    WebElement botaoTransferencia;
    @FindBy(name = "accountNumber")
    WebElement campoNumeroConta;
    @FindBy(name = "digit")
    WebElement campoDigitoFinalConta;
    @FindBy(name = "transferValue")
    WebElement campoTransferirValor;
    @FindBy(name = "description")
    WebElement campoDescricao;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/form/button")
    WebElement botaoConfirmarTransferencia;
    @FindBy(id = "btnCloseModal")
    WebElement botaoFecharModal;
    @FindBy(id = "btnBack")
    WebElement botaoVoltarPagina;

    public TransferenciaPage menuTransferencia(){
        this.botaoTransferencia.click();
        return new TransferenciaPage(driver);
    }

    public TransferenciaPage paginaTransferencia(Integer numeroConta,
                                                 Integer digitoFinal,
                                                 double valorATransferir,
                                                 String descricao){
        this.campoNumeroConta.sendKeys(String.valueOf(numeroConta));
        this.campoDigitoFinalConta.sendKeys(String.valueOf(digitoFinal));
        this.campoTransferirValor.sendKeys(String.valueOf(valorATransferir));
        this.campoDescricao.sendKeys(descricao);
        this.botaoConfirmarTransferencia.click();

        return new TransferenciaPage(driver);
    }

    public TransferenciaPage fecharModal(){
        espera.until(ExpectedConditions.elementToBeClickable(botaoFecharModal));
        this.botaoFecharModal.click();
        this.botaoVoltarPagina.click();
        return new TransferenciaPage(driver);
    }
}
