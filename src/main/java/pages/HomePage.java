package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {

    public HomePage(PageManager pages) {
        super(pages);
    }

    public void goToLink(String http) {
        driver.get(http);
    }

    public String getTitle(){
        driver.get("https://github.com/");
        wait.until(ExpectedConditions.titleIs(driver.getTitle()));
        return driver.getTitle();
    }

}
