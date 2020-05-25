package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MarketplacePage extends Page {

    MarketplacePage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//a[contains(@href , 'actions') and contains(@class, 'muted')]")
    WebElement actionsButton;

    @FindBy(xpath = "(//p[@class='mb-5']/span)[1]")
    WebElement resultCount;

    @FindBy(xpath = "(//p[@class='mb-5']/span)[3]")
    WebElement filteredByCategory;

    @FindBy(xpath = "//a[@class='delete-topic-link f5']")
    WebElement searchedTypeDeleteButton;

    @FindBy(xpath = "//input[@name ='query']")
    WebElement searchField;

    @FindBy(xpath = "(//a[contains(@class , 'd-flex flex-j')])[2]//*[local-name() = 'svg']")
    WebElement actionDeleteButton;

    @FindBy(xpath = "(//a[@class = 'btn-mktg btn-outline-mktg'])[2]")
    WebElement exploreActionButton;


    public void actionButtonSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(actionsButton));
        actionsButton.click();
    }

    public String getTextFromResultCount(){
        String result = resultCount.getText();
        return result;
    }

    public String getTextFromSearchedType(){
        String searchedTypeText = filteredByCategory.getText();
        return searchedTypeText;
    }

    public void submitSearchedTypeDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchedTypeDeleteButton));
        searchedTypeDeleteButton.click();
    }

    public void enterToSerachField(String text){
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickOnActionsDeleteButton(){
        actionDeleteButton.click();
    }

    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }

    public void clickOnExploreActionsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(exploreActionButton));
        exploreActionButton.click();
    }

}
