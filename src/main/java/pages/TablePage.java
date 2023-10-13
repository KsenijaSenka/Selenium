package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TablePage extends BasicPage{

    public TablePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public int getRowNumber(){
        return driver.findElements(By.cssSelector("tbody tr")).size();
    }
    public void clickOnEditButtonByRowIndex(int rowIndex){
        driver.findElements(By.className("update")).get(rowIndex).click();
    }
}
