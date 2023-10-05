package d03_10_2023;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com/iframe/K5yrx
public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "https://s.bootsnipp.com/iframe/K5yrx";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(url);
    }

    //Test #1
    @Test
    public void editRow() {
        String firstName = "Jelica";
        String lastName = "Jelic";
        String middleName = "Marica";

        wait.until(ExpectedConditions.urlContains("https://s.bootsnipp.com/iframe/K5yrx"));
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com");
        driver.findElement(By.xpath("//*[@id='d1']/td[5]/button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='edit']/div[2]")));
        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("fn")).sendKeys(firstName);
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("ln")).sendKeys(lastName);
        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("mn")).sendKeys(middleName);
        driver.findElement(By.id("mn")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("up")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='edit']/div[2]"), 0));
        Assert.assertEquals(firstName, driver.findElement(By.id("f1")).getText(),
                "Input text should be equal to user's first name");
        Assert.assertEquals(lastName, driver.findElement(By.id("l1")).getText(),
                "Input text should be equal to user's last name");
        Assert.assertEquals(middleName, driver.findElement(By.id("m1")).getText(),
                "Input text should be equal to user's middle name");

    }
//Test #2
    @Test
    public void deleteRow() {
        String firstName = "Jelica";
        String lastName = "Jelic";
        String middleName = "Marica";

        wait.until(ExpectedConditions.urlContains("https://s.bootsnipp.com/iframe/K5yrx"));
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
                .xpath("//tr[@id='d1']//button[@data-target='#delete']"))));
        wait.withMessage("Delete button is not clickable");

        driver.findElement(By
                .xpath("//tr[@id='d1']//button[@data-target='#delete']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-open")));
        wait.withMessage("Modal is not visible");

        driver.findElement(By.id("del")).click();
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//*[@id='delete']/div[2]/div"), 0));
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        Assert.assertEquals(rows.size(), 2, "Number of rows should be 2");
    }

    //Test #3:
    @Test
    public void takeAScreenshot() throws IOException {
        wait.until(ExpectedConditions.urlContains("https://s.bootsnipp.com/iframe/K5yrx"));
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com");

        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f, new File("C:\\Users\\Bane i Senka\\Desktop\\Projekti\\Selenium_Osnove\\screenshots" +
                "\\bootsnip.jpg"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}


