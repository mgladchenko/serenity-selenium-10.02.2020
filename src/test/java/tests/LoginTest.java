package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

    @Test
    public void negativeLoginTest() {
        user
                .auth()
                .login("a@b.c", "P@ssword123")
                .validatePageHeader("Don't miss your next opportunity. Sign in to stay updated on your professional world.");
    }

}
