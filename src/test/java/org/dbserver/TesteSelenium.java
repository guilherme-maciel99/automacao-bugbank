package org.dbserver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.dbserver.fluentPageObjects.pages.*;
import org.dbserver.utils.BaseTest;
import org.dbserver.utils.ListaContas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteSelenium extends BaseTest {
    private final WebDriver driver = getDriver();

    private ExtentReports extent = new ExtentReports();
    private ExtentTest teste;
    private RegistroPage registroPage;
    private HomePage homePage;
    private TransferenciaPage transferenciaPage;
    private ExtratoPage extratoPage;
    private DeslogarPage deslogarPage;

    private ListaContas listaContas;

    private String numeroContaTransferencia, saldoPrimeiraConta, saldoSegundaConta;


    @Test
    void fazTesteAutomatizado() {
        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("relatorio-teste.html");
        extent.attachReporter(htmlReporter);
        teste = extent.createTest("Teste Automatizado");
        try {
            Integer conta, digito;
            String[] separadorConta;

            this.listaContas = new ListaContas();
            this.homePage = new HomePage(driver)
                    .clicaEmRegistrar();
            this.registroPage = new RegistroPage(driver, listaContas)
                    .paginaCadastro("aaa@aaa.com",
                            "aaa",
                            "123",
                            "123",
                            false)
                    .fecharModal();
            this.homePage = new HomePage(driver)
                    .clicaEmRegistrar();
            this.registroPage = new RegistroPage(driver, listaContas)
                    .limparCampos()
                    .paginaCadastro("bbb@bbb.com",
                            "bbb",
                            "456",
                            "456",
                            true)
                    .fecharModal();
            numeroContaTransferencia = listaContas.getContaPorPosicao();
            separadorConta = numeroContaTransferencia.split("-");
            conta = Integer.parseInt(separadorConta[0]);
            digito = Integer.parseInt(separadorConta[1]);
            this.homePage = new HomePage(driver)
                    .preencheAcesso("aaa@aaa.com",
                            "123");
            this.transferenciaPage = new TransferenciaPage(driver)
                    .menuTransferencia()
                    .paginaTransferencia(conta,
                            digito,
                            5.70,
                            "Transferencia Teste")
                    .fecharModal();
            this.extratoPage = new ExtratoPage(driver)
                    .abrirExtrato();
            saldoPrimeiraConta = extratoPage.verificarSaldo();
            this.deslogarPage = new DeslogarPage(driver)
                    .sairConta();
            this.homePage = new HomePage(driver)
                    .preencheAcesso("bbb@bbb.com",
                            "456");
            this.extratoPage = new ExtratoPage(driver)
                    .abrirExtrato();
            saldoSegundaConta = extratoPage.verificarSaldo();
            assertEquals(saldoPrimeiraConta, "R$ 994,30");
            assertEquals(saldoSegundaConta, "R$ 1.005,70");
            teste.log(Status.PASS, "Teste executado com sucesso.");
        } catch (AssertionError e) {
            teste.log(Status.FAIL, "Teste falhou: " + e.getMessage());
            throw e;
        }
    }


}
