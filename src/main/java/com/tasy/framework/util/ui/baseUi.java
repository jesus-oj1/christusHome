//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tasy.framework.util.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class baseUi<By> {
    public WebDriver driver;
    WebDriverWait wait;
    int timeOuttSec = 10;

    public baseUi(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(timeOuttSec));
    }

    public void visits(String url) {
        driver.get(url);
    }

    public WebElement find(By element) {
        return driver.findElement((org.openqa.selenium.By) element);
    }

    public void click(By element) {
        isDisplayed(element);
        wait.until(ExpectedConditions.visibilityOfElementLocated((org.openqa.selenium.By) element));
        wait.until(ExpectedConditions.elementToBeClickable((org.openqa.selenium.By) element));
        find(element).click();
    }

    public void type(By element, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((org.openqa.selenium.By) element));
        clear(element);
        find(element).sendKeys(text);
    }

    public boolean isDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated((org.openqa.selenium.By) locator));
            return true;
        } catch (TimeoutException var3) {
            System.out.println("No se encontro el Locater " + locator);
            return false;
        }
    }

    public boolean isDiplayedClick(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable((org.openqa.selenium.By) locator));
            return true;
        } catch (TimeoutException var4) {
            System.out.println("No se pudo dar clic" + var4);
            return false;
        }
    }

    public void clear(By element) {
        isDisplayed(element);
        find(element).clear();
    }

    public String getText(By element) {
        isDisplayed(element);
        String getText = find(element).getText();
        return getText;
    }

    public boolean scrollToElement() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-750)", "");
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public void waitForPageToLoad() {
        String pageLoadStatus = "";
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            do {
                pageLoadStatus = (String) js.executeScript("return document.readyState");
            } while (!pageLoadStatus.equals("complete"));
        } catch (JavascriptException jse) {
            System.err.println("Class: JavaScriptExample | Method: waitForPageToLoad | Exception: " + jse.getMessage());
        }
    }

    public void scrollWindow(String scrollType) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            switch (scrollType) {
                case "up" -> js.executeScript("window.scrollBy(0,-250)");
                case "down" -> js.executeScript("window.scrollBy(0,250)");
                default -> System.err.println("Bad Option");
            }
        } catch (JavascriptException jse) {
            System.err.println("Class: JavaScriptExample | Method: scrollWindow | Exception: " + jse.getMessage());
        }
    }

    public void updateFile(By element) {
        isDisplayed(element);
        WebElement prueba = find(element);
        prueba.sendKeys("C:\\Users\\Luis Reyes Savage\\Desktop\\AutomationTasy\\src\\test\\resources\\Prueba.pdf");
    }

    public void clickderecho(By element) {
        isDisplayed(element);
        WebElement clickderecho = driver.findElement((org.openqa.selenium.By) element);
        Actions actions = new Actions(driver);
        actions.contextClick(clickderecho).perform();

    }

    public void doubleClick(By element) {
        isDisplayed(element);
        WebElement dobleclick = driver.findElement((org.openqa.selenium.By) element);
        Actions actions = new Actions(driver);
        actions.doubleClick(dobleclick).perform();
    }

    public void contatenarLocaterPerfil(String perfil) {
        org.openqa.selenium.By seleccionPerfil = org.openqa.selenium.By.xpath("(//div[@ng-mouseover='adjustChildPosition($event);showTooltipIfHasElipsis($event)'][contains(text(),'" + perfil + "')])[1]");
        if (isDisplayed((By) seleccionPerfil)) {
            click((By) seleccionPerfil);
        }
    }

    public void contatenarSector(String sector1, String sector2) {
        org.openqa.selenium.By seleccionSector = org.openqa.selenium.By.xpath("//div[normalize-space()='" + sector1 + "']");
        org.openqa.selenium.By seleccion = org.openqa.selenium.By.xpath("//div[normalize-space()='" + sector2 + "']");
        if (isDisplayed((By) seleccionSector)) {
            click((By) seleccionSector);
            if (isDisplayed((By) seleccion)) {
                click((By) seleccion);
            }
        }
    }

    public void ComboBoxClick(By clickComboBox, String TextoSeleccionado)  {
        isDisplayed(clickComboBox);
        click(clickComboBox);
        org.openqa.selenium.By texto = org.openqa.selenium.By.linkText(TextoSeleccionado);
        System.out.println("Lo seleccionado en el ComnoBox es: " + TextoSeleccionado);
        isDisplayed((By) texto);
        click((By) texto);
    }

   /* public void seleccionDeModulo(String modulo) throws InterruptedException {
        org.openqa.selenium.By selecionmodulo = org.openqa.selenium.By.xpath("//span[normalize-space()='" + modulo + "']");
        System.out.println("El modulo seleccinado es: " + modulo);
        if (isDisplayed((By) selecionmodulo)) {
            click((By) selecionmodulo);
        }
    }*/

    public String fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        Calendar calendar = new GregorianCalendar();
        String fecha = sdf.format(calendar.getTime());
        return fecha;
    }

    public int elements(By Elements) {
        isDisplayed(Elements);
        List<WebElement> elememts = driver.findElements((org.openqa.selenium.By) Elements);
        int numero = elememts.size();
        return numero;
    }

    public void wait(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }

    public void highLight(By element) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                new Object[]{element, "color: red; border: 4px solid red;"});
    }


}
