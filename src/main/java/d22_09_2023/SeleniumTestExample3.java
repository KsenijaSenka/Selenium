package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

//Napisati program koji:
//ima niz od 5 stringova. Svaki element u nizu je url stranice:
//https://www.google.com/
//https://www.facebook.com/
//https://www.youtube.com/
//https://www.ebay.com/
//https://www.katalon.com/
//zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu
// prateci sledeca pravila:
//za svaku stranicu se kreira nova infrastuktura
//ucitava stranica
//pravi pauza od 1s
//ponistava testna stuktura
public class SeleniumTestExample3 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> linkovi = new ArrayList<>();
        linkovi.add("https://www.google.com/");
        linkovi.add("https://www.facebook.com/");
        linkovi.add("https://www.youtube.com");
        linkovi.add("https://www.ebay.com/");
        linkovi.add("https://www.katalon.com/");

        for (int i = 0; i < linkovi.size(); i++) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get(linkovi.get(i));
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
