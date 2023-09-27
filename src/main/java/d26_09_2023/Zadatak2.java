package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//Napisati program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//Klikce na svaki iks da ugasi obavestenje i proverava
// da li se nakon klika element obrisao sa stranice
// i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        List<WebElement> elements = driver.findElements(By.cssSelector(".alert>button"));

        for (int i = elements.size() - 1; i >= 0; i--) {
            int previousSize = elements.size();
            System.out.println(previousSize);
            elements.get(i).click();
            elements = driver.findElements(By.cssSelector(".alert>button"));
            if (previousSize - elements.size() == 1) {
                System.out.println("Deleted");
            } else {
                System.out.println("Not deleted");
            }
            Thread.sleep(1000);
        }
        driver.close();
    }
}
