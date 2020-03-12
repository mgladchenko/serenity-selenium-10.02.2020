package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.core.Every;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import pages.SearchPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class SearchSteps extends ScenarioSteps {
    private SearchPage searchPage;


    @Then("I should see $searchTerm in each search result")
    @Step
    public SearchSteps verifyEachResultContains(String searchTerm) {
        List<String> searchResultsList = searchPage.getSearchResultsList();
        Assert.assertThat("SearchTerm not found.", searchResultsList,
                Every.everyItem(containsString(searchTerm)));
        return this;
    }

    @Then("I validate each search result")
    @Step
    public SearchSteps verifyEachResultContains() {
        List<String> searchResultsList = searchPage.getSearchResultsList();
        Assert.assertThat("SearchTerm not found.", searchResultsList,
                Every.everyItem(anyOf(containsString("hr"), containsString("HR")))
        );
        return this;
    }

}
