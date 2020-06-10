
import org.testng.Assert;
import org.testng.annotations.Test;
import util.DataProviderClass;
import util.PropertyLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FirstTest extends TestBase {

    @Test
    public void loginTest() {
        app.getNavigationHelper().goToLink("https://github.com/");
        app.getUserHelper().enterUserLogin("Panch31", "mAEege4jJW");
        Assert.assertEquals(app.getUserHelper().getUserName("https://github.com/Panch31/"), "Panch31");
    }

    @Test
    public void linkTest() {
        app.getNavigationHelper().goToLink("https://github.com/");
        Assert.assertEquals(app.getNavigationHelper().getTittle(app.getNavigationHelper().getCurrentUrl()),
                "The world’s leading software development platform · GitHub");
    }

    @Test
    public void followTest() {
        app.getNavigationHelper().goToLink("https://github.com/pprettytony");
        Assert.assertEquals(app.getUserHelper().followPrettyTony(), "Unfollow");
    }

    @Test
    public void unFollowTest() {
        app.getNavigationHelper().goToLink("https://github.com/pprettytony");
        Assert.assertEquals(app.getUserHelper().unFollowPrettyTony(), "Follow");
    }

    @Test
    public void repoTest() {
        app.getNavigationHelper().goToLink("https://github.com/");
        app.getRepositoryHelper().enterToSearchField("Java");
        app.getRepositoryHelper().getRepoSearchListString().forEach(elem -> Assert.assertTrue(elem.toString()
                .toLowerCase().contains("java")));

        Integer sum = app.getRepositoryHelper().getNumbersSearchListInt().stream()
                .mapToInt(elem -> (int) elem)
                .sum();// спросить артура!!!
        Assert.assertTrue(sum > 100000);
        System.out.println(sum);
    }

    @Test
    public void marketplaceTest(){
        app.getNavigationHelper().goToLink("https://github.com/marketplace");
        app.getMarketplaceHelper().actionButtonClick();
        String resultCountInActionPage = app.getMarketplaceHelper().getTextFromResultCountInSearchedPage();
        String filteredBy = app.getMarketplaceHelper().getTextFromFilteredBy();
        app.getMarketplaceHelper().searchByAnotherWord("app");

        Assert.assertTrue(filteredBy.contains("Actions"));
        Assert.assertNotEquals(resultCountInActionPage, app.getMarketplaceHelper()
                .getTextFromResultCountInSearchedPage());
        Assert.assertNotEquals(filteredBy, app.getMarketplaceHelper()
        .getTextFromFilteredByInSearchedPage());

    }

    @Test
    public void marketPlaceLinkTest(){
        app.getNavigationHelper().goToLink("https://github.com/marketplace");
        app.getMarketplaceHelper().actionButtonClick();
        app.getMarketplaceHelper().clickOnActionsDeleteButtonOnMarketPlaceActionsPage();

        String actionsPageUrl = app.getNavigationHelper().getCurrentUrl();
        Assert.assertEquals(actionsPageUrl, "https://github.com/marketplace");

        app.getMarketplaceHelper().clickOnExploreActionsButtonOnMarketPlacePage();
        String marketplaceUrl = app.getNavigationHelper().getCurrentUrl();
        Assert.assertEquals(marketplaceUrl, "https://github.com/marketplace?type=actions");

        Assert.assertNotEquals(actionsPageUrl, marketplaceUrl);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class)
    public void dataProviderTest(String data)
    {
        app.getNavigationHelper().goToLink("https://github.com/");
        app.getRepositoryHelper().enterToSearchField(data);
        app.getRepositoryHelper().getRepoSearchListString().forEach(elem -> Assert.assertTrue(elem.toString()
                .toLowerCase().contains(data)));
        System.out.println("Data is: " + data);
    }

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviderClass.class)
    public void loginDataProviderTest(String userName, String email)
    {
        app.getNavigationHelper().goToLink("https://github.com/");
        userName = PropertyLoader.loadProperty("userGithub.name");
        String login = app.getUserHelper().invalidUserLogin(userName);
        Assert.assertTrue(login.contains("is available"));
        Assert.assertTrue(login.contains("is not available."));
        String userEmail = app.getUserHelper().invalidUserEmail(email);
        Assert.assertTrue(userEmail.contains("Email is invalid"));
    }

    @Test
    public void profileTest(){
        app.getNavigationHelper().goToLink("https://github.com/");
        System.out.println(PropertyLoader.loadProperty("userGithub.name"));
        String login = app.getUserHelper().invalidUserLogin(PropertyLoader.loadProperty("userGithub.name"));
        Assert.assertTrue(login.contains("is not available"));
    }
}


