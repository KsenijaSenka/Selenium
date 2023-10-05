package d02_10_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='active-face']/img")));
        driver.findElement(By.xpath("//*[@id='active-face']/img"))
                .click();
        driver.findElement(By.id("image-option-remove")).click();
        driver.findElement(By.xpath("//*[@id='active-face']/img")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div")));
        driver.findElement(By.id("imageUpload")).sendKeys("C:\\Users\\Bane i Senka\\" +
                "Desktop\\Projekti\\Selenium_Osnove\\i bloody love you\\front.jpg");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("sc-gLDzan"), 1));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.id("image-crop-done-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='active-face']/img")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div[1]/div")));

        driver.findElement(By.id("imageUpload")).sendKeys("C:\\Users\\Bane i Senka\\" +
                "Desktop\\Projekti\\Selenium_Osnove\\i bloody love you\\right.jpg");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("sc-gLDzan"), 2));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.id("image-crop-done-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='active-face']/img")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div[1]/div")));
        driver.findElement(By.id("imageUpload")).sendKeys
                ("C:\\Users\\Bane i Senka\\Desktop\\Projekti\\Selenium_Osnove\\i bloody love you\\back.jpg");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("sc-gLDzan"), 3));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.id("image-crop-done-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='active-face']/img")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div[1]/div")));
        driver.findElement(By.id("imageUpload")).sendKeys
                ("C:\\Users\\Bane i Senka\\Desktop\\Projekti\\Selenium_Osnove\\i bloody love you\\left.jpg");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("sc-gLDzan"), 4));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.id("image-crop-done-button")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("textareaID"))
                .sendKeys("Branislave, izvini sto sam ti uzela slike za projekat.");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
