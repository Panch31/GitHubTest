package util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "dataProvider")
        public static Object[][] dataProviderMethod() {
            return new Object[][] { { "data" }, { "java" }, {"action"} };
        }
    }

