package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Ucitati stranicu http://seleniumdemo.com/?product=bdd-cucumber
//Klik na korpu iz gornjeg desnog ugla
//Sacekati da naslov stranice bude Cart – Selenium Demo Page
//Proveriti da li element koji prikazuje stanje korpe ima tekst
// Your cart is currently empty.
public class Zadatak5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("http://seleniumdemo.com/?product=bdd-cucumber");

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.findElement(By.cssSelector(".mobile-woocart__container>a")).click();

        wait.until(ExpectedConditions.titleIs("Cart – Selenium Demo Page"));

        if (driver.findElement(By.cssSelector(".cart-empty")).getText().equals("Your cart is currently empty.")) {
            System.out.println("Tekst je prisutan.");
        } else {
            System.out.println("Tekst nije prisutan.");
        }
        driver.close();
    }
}
