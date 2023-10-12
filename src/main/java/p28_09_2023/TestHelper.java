package p28_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

//Kreirati klasu TestHelper koja ima:
//privatan atribut driver
//kontukstor sa parametrom
//metodu elementExists koja vraca true ili false ako element postoji.
// Metoda kao parametar prima nacin trazenja By objekat.
// Metoda radi proveru preko TryCatch-a
//metodu elementExistsByList koja takodje vraca true ili false.
// Metoda kao parametar prima By objekat za trazenje.
//metodu setDefaultImplicitWait koja postavlja implicino cekanje na 10s.
//metodu setImplicitWait koja postavlja implicitno cekanje
// iz prosledjene vrednosti.
public class TestHelper {
    private WebDriver driver;
    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }
    public boolean elementExists(By by) {
       // boolean postojiElement = true;
        try {
           // WebElement modal =
                    driver.findElement(by);
        } catch (Exception e) {
            return false;
//        } if (postojiElement) {
//            return true;
//        } else {
//            return false;
       }
        return false;
    }

    public boolean elementExistsByList(By by){

        List<WebElement>  elements =
                driver.findElements(by);

        if (elements.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    public void setDefaultImplicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void setImplicitWait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
