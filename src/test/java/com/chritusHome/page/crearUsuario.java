package com.chritusHome.page;

import com.tasy.framework.util.ui.baseUi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class crearUsuario extends baseUi {
    WebDriver driver;

    By txtboxCorreo = By.xpath("//input[@id='reg_email']");
    By txtboxContaseña = By.xpath("//input[@id='reg_password']");
    By txtboxCorreoConfirmacion = By.xpath("//input[@id='reg_password_confirm']");
    By btnRegistrarse = By.cssSelector("button[value='Registrarse']");
    By getxt =By.xpath("//div[@class='wc-block-components-notice-banner__content']");
    public crearUsuario(WebDriver driver) {
        super(driver);
    }
    public void crearusuario() throws InterruptedException {
        String textoConfirmacion = "Thank you for your registration. Your account has to be activated before you can login. Please check your email.";
        wait(2);
        type(txtboxCorreo,"luis.reyes.savage.lrs@gmail");
        wait(1);
        type(txtboxContaseña,"Aleyma@031293");
        wait(1);
        type(txtboxCorreoConfirmacion,"Aleyma@031293");
        wait(3);
        scrollWindow("down");
        wait(2);
        click(btnRegistrarse);
        System.out.println("Aqui si paso la automatizacion");
        wait(5);

       // if(getText(getxt) == textoConfirmacion){
       //     System.out.println("El texto es el mismo" +textoConfirmacion);
       // }else {
       //     System.out.println("El Texto no es el mismo");
       // }

        Assert.assertEquals(getText(getxt),textoConfirmacion);

    }
}
