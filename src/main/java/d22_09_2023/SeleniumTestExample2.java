package d22_09_2023;
//Napisati program koji:
//ima niz od 5 stringova. Svaki element u nizu je url stranice:
//https://www.google.com/
//https://www.facebook.com/
//https://www.youtube.com/
//https://www.ebay.com/
//https://www.katalon.com/
//kreira testnu infrastukturu
//zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu
// i pritom pravi pauzu od 2 sekunde izmedju svaka dva ucitanja stranice
//Na kraju program ponisava testnu ifrastukturu
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class SeleniumTestExample2 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> linkovi = new ArrayList<>();
        linkovi.add("https://www.google.com/");
        linkovi.add("https://www.facebook.com/");
        linkovi.add("https://www.youtube.com");
        linkovi.add("https://www.ebay.com/");
        linkovi.add("https://www.katalon.com/");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        for (int i = 0; i < linkovi.size(); i++) {
            driver.get(linkovi.get(i));
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
