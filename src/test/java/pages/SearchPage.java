package pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends PageObject {

    @FindBy(xpath = "//li[contains(@class, 'search-result ')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultsTotal;

    public boolean isPageLoaded() {
        try {
            waitFor(ExpectedConditions.visibilityOf(searchResultsTotal));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<>();
        for (WebElement searchResult : searchResults) {
            evaluateJavascript("arguments[0].scrollIntoView(true);", searchResult);
            searchResultsList.add(searchResult.getText());
        }
        return searchResultsList;
    }


}
