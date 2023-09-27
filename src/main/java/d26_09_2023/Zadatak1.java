package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;

//Napisati program koji:
//Ucitava stranicu https://demoqa.com/automation-practice-form
//Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
//(za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
//Klik na submit
public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");
        Scanner s = new Scanner(System.in);
        Thread.sleep(500);


        System.out.print("Unesite ime: ");
        String firstName = s.next();
        driver.findElement(By.id("firstName")).sendKeys(firstName);

        System.out.println("Unesite prezime: ");
        String lastName = s.next();
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        System.out.println("Unesite mail");
        String email = s.next();
        driver.findElement(By.id("userEmail")).sendKeys(email);

        System.out.println("Unesite pol: ");
        String gender = s.next();
        if (gender.equals("male")) {
            driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        } else if (gender.equals("female")) {
            driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
        } else if (gender.equals("other")) {
            driver.findElement(By.xpath("//label[@for='gender-radio-3']")).click();
        }

        System.out.println("Unesite telefon: ");
        String userNumber = s.next();
        driver.findElement(By.id("userNumber")).sendKeys(userNumber);


        System.out.println("Unesite hobi: ");
        driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]/label")).click();

        System.out.println("Unesite sliku: ");
        driver.findElement(By.id("uploadPicture"))
                .sendKeys("C:\\Users\\Bane i Senka\\Pictures\\Screenshots\\SS11br.png");

        System.out.println("Unesite adresu: ");
        String currentAddress = s.next();
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);

        WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]"));

        Select select = new Select(selectElement);
        String value = s.next();
        select.selectByValue(value);

        WebElement selectElementCity = driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
        Select selectCity = new Select(selectElementCity);
        String valueCity = s.next();
        selectCity.selectByValue(valueCity);
        Thread.sleep(2000);

        driver.findElement(By.id("submit")).click();

    }
}
