package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

    public class MarketplaceSearchedPage extends Page {

        MarketplaceSearchedPage(PageManager pages) {
            super(pages);
        }

        @FindBy(xpath = "(//p[@class='mb-5']/span)[1]")
        WebElement resultCount;

        @FindBy(xpath = "(//p[@class='mb-5']/span)[2]")
        WebElement searchedFor;

        public String getTextFromResultCount(){
            String result = resultCount.getText();
            return result;
        }

        public String getTextFromSearchedFor(){
            String searchedForText = searchedFor.getText();
            return searchedForText;
        }

    }


