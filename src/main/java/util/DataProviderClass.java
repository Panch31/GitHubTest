package util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "dataProvider")
        public static Object[][] dataProviderMethod() {
            return new Object[][] { { "data" }, { "java" }, {"action"} };
        }


    @DataProvider(name = "loginDataProvider")
    public static Object[][] loginDataProviderMethod() {
        return new Object[][] { { "user1", "pass1" }, { "user2", "pass2" }, {"user3", "pass3"} };
    }
}

