package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Ucitati stranu
//https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//Selektujte delay od 2000ms, koristeci Select klasu.
//Skrol do Show more dugmeta koje se nalazi na dnu stranice
//Sacekajte da dugme bude klikljivo
//Klik na Show more dugme
//Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//Sacekajte da dugme vise ne bude klikljivo
public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        Select select = new Select(driver.findElement(By.name("delay-select")));
        select.selectByVisibleText("2000ms");
        Thread.sleep(1000);

        new Actions(driver)
                .scrollToElement(driver.findElement(By.xpath("//*[@id='infinite-scroll-button']")));
        new Actions(driver).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='infinite-scroll-button']"))));

        driver.findElement(By.xpath("//*[@id='infinite-scroll-button']")).click();

        int elementCount = driver.findElements(By.className("card")).size();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("card"), elementCount));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='infinite-scroll-button']")));

        driver.quit();
    }
}
