package helpers;

import managers.AppManager;
import pages.FollowPage;
import pages.LoginPage;
import pages.PageManager;

public class UserHelper extends PageManager {
    public UserHelper() {
        super(AppManager.getWebDriver());
    }


    public void enterUserLogin(String name, String pass){
        loginPage.clickOnLoginButton();
        loginPage.enterToLoginField(name);
        loginPage.enterToPasswordField(pass);
        loginPage.clickOnSubmitButton();
    }

    public String getUserName(String userLink){
        return loginPage.getName(userLink);
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
