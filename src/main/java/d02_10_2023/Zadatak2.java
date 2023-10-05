package d02_10_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Napisati program koji:
//Ucitava stranu https://itbootcamp.rs/
//Misem prelazi preko Vesti iz navigacionog menija
//Ceka da se prikaze padajuci meni za Vesti
//Misem prelazi preko Kursevi iz navigacionog menija
//Ceka da se prikaze padajuci meni za Kursevi
//Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//Ceka da se prikaze padajuci meni za Prijava i pravilnik
//Koristan link. Mouse over preko seleniuma
//https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element
public class Zadatak2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://itbootcamp.rs/");

        WebElement vesti = driver.findElement(By.xpath("//*[@id='menu-item-6408']/a"));
        new Actions(driver)
                .moveToElement(vesti)
                .perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-5375']")));

        WebElement kursevi = driver.findElement(By.xpath("//*[@id='menu-item-5362']/a"));
        new Actions(driver)
                .moveToElement(kursevi)
                .perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-5362']/ul")));

        WebElement prijava = driver.findElement(By.xpath("//*[@id='menu-item-5453']/a"));
        new Actions(driver)
                .moveToElement(prijava)
                .perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-5374']")));

        driver.close();

    }
}
