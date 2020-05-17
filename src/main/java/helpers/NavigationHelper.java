package helpers;

import managers.AppManager;
import org.openqa.selenium.WebDriver;
import pages.PageManager;

public class NavigationHelper extends PageManager {

    public NavigationHelper() {
        super(AppManager.getWebDriver());
    }

    public void goToLink(String http){
        homePage.goToLink(http);
    }

    public String getTittle(){
        return homePage.getTitle();
    }

}
