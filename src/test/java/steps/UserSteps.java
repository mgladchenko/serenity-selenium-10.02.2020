package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.LandingPage;
import pages.LoginChallengePage;

public class UserSteps extends ScenarioSteps {

    private LandingPage landingPage;
    private LoginChallengePage loginChallenge;

    @Step
    public UserSteps login(String userEmail, String userPassword) {
        landingPage.open();
        landingPage.login(userEmail, userPassword);
        waitABit(60000);
        return this;
    }

    @Step
    public UserSteps validatePageHeader(String expectedMessage) {
        Assert.assertEquals("Wrong header message.", expectedMessage, loginChallenge.getHeaderMessageText());
        return this;
    }

}
