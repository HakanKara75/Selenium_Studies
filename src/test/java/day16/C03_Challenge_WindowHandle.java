package day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Set;
public class C03_Challenge_WindowHandle extends TestBase {
    @Test
    public void windowHandleTest() throws InterruptedException {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com");
        ExpectedConditions.titleIs("ToolsQA");
        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[3]")).click();
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        String expectedText="Please select an item from left to start practice.";
        String actualText=driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']")).getText();
        Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("(//li[@id='item-0'])[3]")).click();
        //New Tab butonunun görünür olduğunu doğrula
        WebElement NewTab=driver.findElement(By.xpath("//button[@id='tabButton']"));
        Assert.assertTrue(NewTab.isDisplayed());
        //New Tab butonuna click yap
        String windowHAndle = driver.getWindowHandle();
        System.out.println(windowHAndle);
        NewTab.click();
        Set<String> h1 = driver.getWindowHandles();
        for (String windowHandle : h1) {
            if (!windowHandle.equals(windowHAndle)) {
                driver.switchTo().window(windowHandle);
            }
        }
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1[@id='sampleHeading']"));
        String actualTextTab2=driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        String expectedTextTab2="This is a sample page";
        Assert.assertTrue(actualTextTab2.equals(expectedTextTab2));
        //İlk Tab'a geri dön
        Set<String> h2 = driver.getWindowHandles();
        for (String windowHandle : h2) {
            if (!windowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
        driver.switchTo().window(windowHAndle);
        ////New Tab butonunun görünür olduğunu doğrula
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(NewTab.isDisplayed());
    }
}