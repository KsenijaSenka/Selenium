package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Ucitati stranicu http://seleniumdemo.com/?post_type=product
//Klik na search dugme u gornjem desnom uglu
//Cekati da forma za pretragu bude vidljiva
//Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
//Dohvatiti prvi rezultat pretrage i proveriti
// da li u nazivu sadrzi tekst koji je unet za pretragu.
// Ispisati odgovarajuce poruke u terminalu
public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("http://seleniumdemo.com/?post_type=product");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.cssSelector(".nav__utils.regular-nav li.nav__search > a")).click();
        WebElement input = driver.findElement(By.xpath("//*[@id='s-651536d626b54']"));
        wait.until(ExpectedConditions.visibilityOf(input));
        String text = "BDD Cucumber";
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#post-29  h2 > a")));

        if (driver.findElement(By.cssSelector("#post-29  h2 > a")).getText().contains(text)) {
            System.out.println("Tekst je prisutan.");
        } else {
            System.out.println("Tekst nije prisutan.");
        }

        Thread.sleep(1000);
        driver.close();

    }
}
