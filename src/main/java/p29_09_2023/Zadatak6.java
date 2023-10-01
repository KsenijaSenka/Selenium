package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//Napisati program koji:
//Ucitava stranicu
// https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//Ceka da broj toasts-a bude 4
//Ispisuje poruku, toasts su prikazani
//Ceka da broj toasts-a bude 0
//Ispisuje poruku, toasts su se izgubili
public class Zadatak6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.manage().window().maximize();

        driver.findElement(By.id("basic-primary-trigger")).click();
        driver.findElement(By.id("basic-secondary-trigger")).click();
        driver.findElement(By.id("basic-success-trigger")).click();
        driver.findElement(By.id("basic-danger-trigger")).click();


        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//div[contains(@class,'toast-fixed show')]"), 4));
        System.out.println("Prikazani su.");
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//div[contains(@class,'toast-fixed show')]"), 0));
        System.out.println("Izgubili su se.");
    }
}
