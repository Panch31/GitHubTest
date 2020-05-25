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

    @FindBy(xpath = "//span[@class = 'js-jump-to-badge-search-text-global']")
    WebElement searchFieldButton;
    @FindBy(xpath = "//input[@name = \'q\']")
    WebElement searchField;

    public void goToLink(String http) {
        driver.get(http);
    }

    public String getTitle(String text){
        driver.get(text);
        wait.until(ExpectedConditions.titleIs(driver.getTitle()));
        return driver.getTitle();
    }

    public void enterToSearchField(String textToSearchField){
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(textToSearchField);
        searchFieldButton.click();
    }

}
