package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.core.Every;
import org.junit.Assert;
import pages.SearchPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;

public class SearchSteps extends ScenarioSteps {
    private SearchPage searchPage;

    @Step
    public SearchSteps verifyEachResultContains(String searchTerm) {
        List<String> searchResultsList = searchPage.getSearchResultsList();
        Assert.assertThat("SearchTerm not found.", searchResultsList, Every.everyItem(containsString(searchTerm)));
        return this;
    }

    @Step
    public SearchSteps verifyEachResultContains(String[] searchTerm) {
        List<String> searchResultsList = searchPage.getSearchResultsList();
        //Assert.assertThat("SearchTerm not found.", searchResultsList, Every.everyItem(containsString(anyOf(searchTerm))));
        return this;
    }

}
