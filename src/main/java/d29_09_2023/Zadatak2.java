package d29_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        driver.manage().window().maximize();

        Select select = new Select(driver.findElement(By.name("delay-select")));
        select.selectByVisibleText("2000ms");
        Thread.sleep(1000);


        WebElement btn = driver.findElement(By.id("infinite-scroll-button"));

        List<WebElement> elements = driver.findElements(By.className("item"));
        for (int i = 0; i <  elements.size(); i++) {
            new Actions(driver).scrollToElement(elements.get(i)).perform();
        }

        new Actions(driver).scrollToElement(btn).perform();

        wait.until(ExpectedConditions.elementToBeClickable(btn));
        btn.click();

        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.className("item"), 8));

        Thread.sleep(5000);
        driver.quit();

    }
}
