package helpers;

import managers.AppManager;
import pages.PageManager;

public class MarketplaceHelper extends PageManager {
    public MarketplaceHelper() {
        super(AppManager.getWebDriver());
    }

    public void actionButtonClick(){
        marketplacePage.actionButtonSubmit();
    }

    public String getTextFromResultCount(){
        String resultCount = marketplacePage.getTextFromResultCount();
        return resultCount;
    }

    public String getTextFromFilteredBy(){
        String filteredBy = marketplacePage.getTextFromSearchedType();
        return filteredBy;
    }

    public void searchByAnotherWord(String text){
        marketplacePage.submitSearchedTypeDeleteButton();
        marketplacePage.enterToSerachField(text);
    }

    public String getTextFromResultCountInSearchedPage(){
        String resultCountFromSearchedPage = marketplaceSearchedPage.getTextFromResultCount();
        return resultCountFromSearchedPage;
    }

    public String getTextFromFilteredByInSearchedPage(){
        String filteredByInSearchPage = marketplaceSearchedPage.getTextFromSearchedFor();
        return filteredByInSearchPage;
    }

    public void clickOnActionsDeleteButtonOnMarketPlaceActionsPage(){
        marketplacePage.clickOnActionsDeleteButton();
    }

    public void clickOnExploreActionsButtonOnMarketPlacePage(){
        marketplacePage.clickOnExploreActionsButton();
    }

}
