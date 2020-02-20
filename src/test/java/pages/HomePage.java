package pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@At("https://www.linkedin.com/feed/")
public class HomePage extends PageObject {

    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement searchField;

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean isPageLoaded() {
        return profileNavItem.isDisplayed();
    }
}
