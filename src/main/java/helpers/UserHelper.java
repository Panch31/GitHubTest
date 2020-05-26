package helpers;

import io.qameta.allure.Step;
import managers.AppManager;
import pages.FollowPage;
import pages.LoginPage;
import pages.PageManager;

public class UserHelper extends PageManager {
    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("loginToGitHub")
    public void enterUserLogin(String name, String pass){
        loginPage.clickOnLoginButton();
        loginPage.enterToLoginField(name);
        loginPage.enterToPasswordField(pass);
        loginPage.clickOnSubmitButton();
    }

    @Step("enterToSugnUpField")
    public String invalidUserLogin(String userName){
        loginPage.enterToSignUpField(userName);
        return loginPage.getTextFromLoginCheckNotification();
    }

    @Step("enterToPassField")
    public String invalidUserPass(String password){
        loginPage.enterToSignUpPassField(password);
        return loginPage.getTextFromPasswordCheckNotification();
    }

    public String getUserName(String userLink){
        return loginPage.getName(userLink);
    }

    @Step("followPrettyTony")
    public String followPrettyTony(){
        followPage.clickOnFollowButton();
        return followPage.getTextFromUnFollowButton();
    }

    @Step("unFollowPrettyTony")
    public String unFollowPrettyTony(){
        followPage.clickOnUnFollowButton();
        return followPage.getTextFromFollowButton();
    }
}
