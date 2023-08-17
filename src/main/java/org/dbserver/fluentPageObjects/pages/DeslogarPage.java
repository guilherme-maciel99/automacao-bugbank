package org.dbserver.fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DeslogarPage {
    WebDriver driver;

    public DeslogarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15),this);
    }

    @FindBy(className = "styles__Link-sc-osobjw-0 xzjxU")
    WebElement botaoSair;

    public DeslogarPage sairConta(){
        this.botaoSair.click();
        return new DeslogarPage(driver);
    }

}
