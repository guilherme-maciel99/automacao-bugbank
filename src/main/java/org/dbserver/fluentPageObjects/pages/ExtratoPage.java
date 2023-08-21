package org.dbserver.fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ExtratoPage {

    WebDriver driver;
    @FindBy(id = "btn-EXTRATO")
    WebElement botaoExtrato;
    @FindBy(id = "textTypeTransaction")
    WebElement textoTipoTransferencia;
    @FindBy(id = "textDescription")
    WebElement textoDescricao;
    @FindBy(id = "textTransferValue")
    WebElement textoValorTransferido;
    @FindBy(id = "textBalanceAvailable")
    WebElement textoValorSaldo;
    @FindBy(id = "btnBack")
    WebElement botaoVoltarPagina;
    public ExtratoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }


    public ExtratoPage abrirExtrato(){
        this.botaoExtrato.click();
        return new ExtratoPage(driver);
    }

    public String verificarSaldo(){
        return this.textoValorSaldo.getText();
    }
    public String getTextoTipoTransferencia() {
        return textoTipoTransferencia.getText();
    }
    public String getTextoDescricao() {
        return textoDescricao.getText();
    }
    public String getTextoValorTransferido() {
        return textoValorTransferido.getText();
    }
}
