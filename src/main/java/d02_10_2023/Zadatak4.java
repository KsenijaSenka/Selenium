package d02_10_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import p02_10_2023.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Napisati program koji:
//Ucitava stranicu https://itbootcamp.rs/
//Skrola do slajdera na dnu stranice
//(u kome su slike Java, Php, Selenium, …)
//Cita sve linkove slika iz slajdera
//Proverava url svake slike, i za sve slike koje imaju status
// veci i jednak od 200 a manji od 300,
//skida i smesta u folder itbootcamp_slider u okviru projekta
//Azurirajte gitignore da ignorise itbootcamp_slider folder
public class Zadatak4 {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://itbootcamp.rs/");

        new Actions(driver).scrollToElement(driver.findElement(By
                        .cssSelector("div.vc_row.wpb_row.vc_row-fluid.slider_bkgd")))
                .perform();

        List<WebElement> images = driver.findElements(By.cssSelector("div.vc_row.wpb_row.vc_row-fluid.slider_bkgd img"));
        List<String> urls = new ArrayList<>();
        List<Integer> codes = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            urls.add(images.get(i).getAttribute("src"));
            codes.add(UrlHelper.getHTTPResponseStatusCode(urls.get(i)));
        }
        for (int i = 0; i < codes.size(); i++) {
            if (codes.get(i) >= 200 && codes.get(i) < 300) {
                Helper.downloadUsingStream(urls.get(i),
                        "C:\\Users\\Bane i Senka\\Desktop\\Projekti\\Selenium_Osnove\\it bootcamp slider\\"
                                + (i + 1) + ".jpg");
            }
        }
    }
}
