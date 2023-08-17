package org.dbserver.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class BaseTest extends DriverManager {
    private static final FileReader file = new FileReader();

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @BeforeEach
    public void setUp() throws IOException {
        String URL = file.getProperties("config").getProperty("url");
        getDriver().get(URL);
    }

    @AfterEach
    public void finish() {
        quitDriver();
    }
}