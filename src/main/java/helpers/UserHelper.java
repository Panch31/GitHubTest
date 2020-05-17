package helpers;

import managers.AppManager;
import pages.FollowPage;
import pages.LoginPage;
import pages.PageManager;

public class UserHelper extends PageManager {
    public UserHelper() {
        super(AppManager.getWebDriver());
    }


    public void enterUserLogin(){
        loginPage.clickOnLoginButton();
        loginPage.enterToLoginField();
        loginPage.enterToPasswordField();
        loginPage.clickOnSubmitButton();
    }

    public String getUserName(){
        return loginPage.getName();
    }

    public String followPrettyTony(){
        followPage.clickOnFollowButton();
        return followPage.getTextFromUnFollowButton();
    }

    public String unFollowPrettyTony(){
        followPage.clickOnUnFollowButton();
        return followPage.getTextFromFollowButton();
    }
}
