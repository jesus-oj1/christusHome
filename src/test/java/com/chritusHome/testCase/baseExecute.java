package com.chritusHome.testCase;

import com.chritusHome.page.crearUsuario;
import com.tasy.framework.util.data.json.JsonUtil;
import com.tasy.framework.util.listeners.testListener;
import com.tasy.framework.util.ui.takeScrennshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.chritusHome.page.homePage;


@Listeners({testListener.class})
public abstract class baseExecute {
    public List<String> addStep = new ArrayList<>();
    public WebDriver driver;
    public WebDriverWait wait;
    takeScrennshot takeScrennshot = new takeScrennshot();
    ChromeOptions options;
    homePage homepage;
    crearUsuario crearUsuario;
    JsonUtil json;

    @BeforeMethod
    public void beforeMethod(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "disable-infobars:", "--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        json = new JsonUtil();
        homepage = new homePage(driver);
        crearUsuario = new crearUsuario(driver);
        driver.get("https://sitioqa.christus.mx/");
    }
   //"pruebas"
    @AfterMethod
    public void afterMehotd(ITestResult result) throws XmlException, IOException {
        driver.close();
        //  new word(addStep,setModulo(),setperfil(),setNombreTester(),setPaquete(),setCasoPrueba(), result.isSuccess());

    }


    public abstract String setModulo();

    public abstract String setperfil();

    public abstract String setCasoPrueba();

    public abstract String setNombreTester();

    public abstract String setPaquete();


}



