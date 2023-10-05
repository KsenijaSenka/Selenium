package d02_10_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//Napisati program koji:
//Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
//Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
//Ceka da se prikazu 4 item-a a upload
//Klik na upload
//Ceka da se upload zavrsi
public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        List<File> uploadFiles = new ArrayList<File>();
        for (int i = 0; i < 4; i++) {
            uploadFiles.add(new File("i bloody love you/back.jpg"));
            uploadFiles.add(new File("i bloody love you/front.jpg"));
            uploadFiles.add(new File("i bloody love you/left.jpg"));
            uploadFiles.add(new File("i bloody love you/right.jpg"));
        }
        for (int i = 0; i < 4; i++) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id=\"fileupload\"]/div/div[1]/span[1]/input")));
            driver.findElement(By
                    .xpath("//*[@id='fileupload']//input")).sendKeys(uploadFiles.get(i).getAbsolutePath());
        }
        wait.until(ExpectedConditions.numberOfElementsToBe(By
                .xpath("//*[@id='fileupload']/table/tbody/tr"), 4));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='fileupload']/div/div[1]/button[1]/span")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath
                ("//*[@id='fileupload']/table/tbody/tr[1]/td[4]/button[2]/span"), 0));
    }
}
