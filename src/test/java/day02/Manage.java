package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Manage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //getSize
        driver.manage().window().getSize(); //sayfanin olculerini verir 1050x832

        //getPosition
        driver.manage().window().getPosition(); //sayfanin pozisyonunu verir. sol alt koseden olcer

        //setPosition
        driver.manage().window().setPosition(new Point(15,15)); //pozisyonu ayarlar

        //setSize
        driver.manage().window().setSize(new Dimension(90,600)); //olcuyu ayarlar

        //implicitlyWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //calisma suresini bekletme. sayfa acilmesini bekler
        //bu surede sayfa acilmazsa hata verir.


        //


    }
}
