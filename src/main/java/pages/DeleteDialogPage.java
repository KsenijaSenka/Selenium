package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteDialogPage extends BasicPage{
    public DeleteDialogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getDialogBody(){
        return driver.findElement(By.cssSelector("#delete .modal-body"));
    }

}
