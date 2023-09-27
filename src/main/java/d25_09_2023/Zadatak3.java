package d25_09_2023;
//Napisati program koji vrsi dodavanje 5 redova
//Maksimizirati prozor
//Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//Klik na dugme Add New
//Unesite name,departmant i phone (uvek iste vrednost)
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Napisati program koji vrsi dodavanje 5 redova
public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");


        for (int i = 0; i <5 ; i++) {
            driver.findElement(By.xpath("//button")).click();
            driver.findElement(By.name("name")).sendKeys("Milomir Mikic");
            driver.findElement(By.name("department")).sendKeys("Insurance");
            driver.findElement(By.name("phone")).sendKeys("099876765");
            driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[@class='add']")).click();
            Thread.sleep(500);
        }

        driver.close();
    }
}
