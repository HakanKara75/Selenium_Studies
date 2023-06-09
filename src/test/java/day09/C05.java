package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

/*
- http://szimek.github.io/signature_pad/ sayfasına gidiniz
- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
- Çizimden sonra clear butonuna basınız
- Sayfayi kapatiniz
 */
public class C05 extends TestBase {
    @Test
    public void test1() {


//    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    driver.get("http://szimek.github.io/signature_pad/");

//            - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement canvas = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);

        actions.moveToElement(canvas).clickAndHold();
        for (int i = 0; i < 15; i++) {
            actions.moveByOffset(5, 5);
        }
        for (int i = 0; i < 15; i++) {
            actions.moveByOffset(-5, -5);
        }
        for (int i = 0; i < 15; i++) {
            actions.moveByOffset(-5, 5);
        }

        for (int i = 0; i < 7; i++) {
            actions.moveByOffset(5, -5);
        }

        for (int i = 0; i < 12; i++) {
            actions.moveByOffset(7,0 );
        }
                actions.release().build().perform();
//2.yol
        actions.moveToElement(canvas).clickAndHold().moveByOffset(0, -200).moveByOffset(100, 0).click()
                .moveToElement(canvas, 0, 0).clickAndHold().moveByOffset(100, 0).click()
                .moveToElement(canvas, 0, 0).clickAndHold().moveByOffset(0, -100).moveByOffset(100, 0).click().moveToElement(canvas, 0, 0).build().perform();
        threadSleep(2);
        // R
        actions.moveByOffset(200, 0).clickAndHold().moveByOffset(0, -200).moveByOffset(100, 0).moveByOffset(0,100).moveByOffset(-100, 0).moveByOffset(100, 100).build().perform();
        threadSleep(2);

        //3.yol
        WebElement cizim = driver.findElement(By.tagName("canvas"));
        Actions ekrandaGorunenler = new Actions(driver);
        ekrandaGorunenler.clickAndHold(cizim)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .release()
                .perform();
//- Çizimden sonra clear butonuna basınız
        WebElement clear = driver.findElement(By.xpath("//button[@data-action='clear']"));
        clear.click();


}
}
