package com.chritusHome.page;

import com.tasy.framework.util.ui.baseUi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends baseUi {

    WebDriver driver;

    By spanOtrasTiendas = By.xpath("//a[normalize-space()='Otras tiendas']");
    By  btnOK = By.xpath("//button[normalize-space()='Aceptar']");

    By btnIniciarSesion = By.xpath("//a[normalize-space()='Iniciar sesión']");


    public homePage(WebDriver driver) {
        super(driver);
    }

    public void otrasTiendas() throws InterruptedException {
        wait(5);
        click(spanOtrasTiendas);
        wait(2);
        click(btnOK);
       // wait(10);
    }

    public void clickIniciarSesion () throws InterruptedException {
        wait(5);
        click(btnIniciarSesion);
        wait(2);
    }
}
