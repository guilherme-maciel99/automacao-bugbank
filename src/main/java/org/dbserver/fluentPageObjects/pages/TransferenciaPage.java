package org.dbserver.fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TransferenciaPage {

    WebDriver driver;

    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
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
    @FindBy(className = "style__ContainerButton-sc-1wsixal-0 CMabB button__child")
    WebElement botaoConfirmarTransferencia;
    @FindBy(className = "styles__Button-sc-8zteav-5 gyHUvN")
    WebElement botaoFecharModal;
    @FindBy(className = "transfer__BackText-sc-1yjpf2r-5 gWmJSZ")
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
        this.botaoFecharModal.click();
        this.botaoVoltarPagina.click();
        return new TransferenciaPage(driver);
    }
}
