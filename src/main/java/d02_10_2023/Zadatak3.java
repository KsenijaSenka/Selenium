package d02_10_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Napisati program koji:
//Ucitava stranicu https://demoqa.com/broken
//Hvata oba linka sa stranice i
//Za svaki link proverava status da je veci ili jednak od 200 i manji od 400

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/broken");

        WebElement url1 = driver.findElement(By.xpath("//*[@id='app']/div//a[1]"));
        String validLink = url1.getAttribute("href");
        WebElement url2 = driver.findElement(By.xpath("//*[@id='app']/div//a[2]"));
        String brokenLink = url2.getAttribute("href");

        List<String> links = new ArrayList<>();
        links.add(validLink);
        links.add(brokenLink);

        List<Integer> codes = new ArrayList<>();
        codes.add(UrlHelper.getHTTPResponseStatusCode(validLink));
        codes.add(UrlHelper.getHTTPResponseStatusCode(brokenLink));

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(links.get(i));
            System.out.println("Response status code: " + codes.get(i));
            if (codes.get(i) >= 200 && codes.get(i) < 400) {
                System.out.println("Status je prihvatljiv.");
            } else if (codes.get(i) >= 400) {
                System.out.println("Status je neprihvatljiv.");
            }
        }
    }
}
