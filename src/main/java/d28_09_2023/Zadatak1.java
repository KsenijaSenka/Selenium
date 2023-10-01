package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Napisati program koji ucitava stranicu
// https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//Klik na Type dropwdown
//Klik na Public iz dropdown
//Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
//Kilk na Clear filter u desnom uglu
public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
        driver.findElement(By.xpath("//*[@id='type-options']/summary")).click();
        driver.findElement(By.xpath("//*[@id='type-options']//label[2]")).click();

        WebElement clear = driver.findElement(By.cssSelector("div.TableObject-item.text-right.v-align-top > a"));
        clear.click();
        wait.until(ExpectedConditions.visibilityOf(clear));

        driver.close();

    }

}
