package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchPage extends Page {

    public SearchPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//div[@class = 'f4 text-normal']")
    List<WebElement> repoSearchList;

    @FindBy(xpath = "//a[@class = 'muted-link']")
    List<WebElement> numbersOfSearchList;

    public List<WebElement> getRepoSearchList(){
        return repoSearchList;
    }

    public List<WebElement> getNumbersOfSearchList(){
        return numbersOfSearchList;
    }
}


