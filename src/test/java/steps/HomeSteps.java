package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import pages.HomePage;

public class HomeSteps extends ScenarioSteps {
    private HomePage homePage;

    @Given("I should see Home page")
    @Then("I should see Home page")
    @Step
    public HomeSteps validateHomePageIsLoaded() {
        Assert.assertTrue("Page is not loaded.", homePage.isPageLoaded());
        return this;
    }

    @When("I search for $searchTerm")
    @Step
    public HomeSteps searchFor(String searchTerm) {
        homePage.searchFor(searchTerm);
        return this;
    }
}
