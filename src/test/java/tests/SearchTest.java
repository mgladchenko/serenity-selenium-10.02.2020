package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.junit.annotations.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class SearchTest extends BaseTest {
    private String searchTerm;

    public SearchTest(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"hr"},
                {"HR"},
                {"Human Resources"}
        });
    }

    @Before
    public void before() {
        user
                .auth()
                .openLandingPage()
                .login("linkedin.tst.yanina@gmail.com", "Test123!");
    }

    @Test
    public void searchBySearchTermTest() {
        String[] relevantResults = {"hr", "HR", "Human Resources", "HUMAN RESOURCES"};
        user
                .validatePageTitle("LinkedIn")
                .homePage()
                .searchFor(searchTerm);
        user
                .validatePageTitle("LinkedIn")
                .searchPage()
                .verifyEachResultContains(searchTerm);
    }
}
