package helpers;

import managers.AppManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PageManager;
import pages.SearchPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryHelper extends PageManager {

    public RepositoryHelper() {
        super(AppManager.getWebDriver());
    }

    public void enterToSearchField(String text) {
        homePage.enterToSearchField(text);
    }

    public List getRepoSearchListString() {
        List<WebElement> repoSearchList = searchPage.getRepoSearchList();
        List<String> repoSearchListString = repoSearchList.stream().map(p -> p.getText()).collect(Collectors.toList());
        return repoSearchListString;
    }

    public List getNumbersSearchListInt() {
        List<WebElement> numbersOfSearchList = searchPage.getNumbersOfSearchList();
        List<String> numbersOfSearchListString = numbersOfSearchList.stream().map(elem -> elem.getText())
                .collect(Collectors.toList());

        numbersOfSearchListString.forEach(System.out::println);

        List<Integer> numbersOfSearchListInt = new ArrayList<>();

        for (String elem : numbersOfSearchListString) {
            if (elem.contains("k")) {
                elem = elem.replace("k", "");
                double d = Double.parseDouble(elem) * 1000;
                Integer i = (int) d;
                numbersOfSearchListInt.add(i);
            } else if (elem.contains(".")) {
                elem = elem.replace(".", "");
                double d = Double.parseDouble(elem) * 10;
                Integer i = (int) d;
                numbersOfSearchListInt.add(i);
            } else numbersOfSearchListInt.add(Integer.parseInt(elem));
        }

        numbersOfSearchListInt.forEach(System.out::println);
        return numbersOfSearchListInt;
    }

}


