
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends TestBase {

    @Test
    public void loginTest() {
        app.getNavigationHelper().goToLink("https://github.com/");
        app.getUserHelper().enterUserLogin();
        Assert.assertEquals(app.getUserHelper().getUserName(), "Panch31");
    }

    @Test
    public void linkTest() {
        app.getNavigationHelper().goToLink("https://github.com/");
        Assert.assertEquals(app.getNavigationHelper().getTittle(),
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

}
