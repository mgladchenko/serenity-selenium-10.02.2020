package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SearchPage;

public class SearchSteps extends ScenarioSteps {
    private SearchPage searchPage;

    @Step
    public SearchSteps verifyEachResultContains(String searchTerm) {
        return this;
    }

}
