package helpers;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import managers.AppManager;
import org.testng.annotations.Listeners;
import pages.FollowPage;
import pages.LoginPage;
import pages.PageManager;
import util.TestListener;

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

    @Step("enter to SignUp Field")
    public String invalidUserLogin(String userName){
        loginPage.enterToSignUpField(userName);
        return loginPage.getTextFromLoginCheckNotification();
    }


    @Step("enter To email field")
    public String invalidUserEmail(String email){
        loginPage.enterToSignUpPassField(email);
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
