package pages.pages2nHaber;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import utils.JSUtilities;
import utils.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;


public class HomePage extends BasePage {


    @FindBy(xpath = "//*[@class='elementor-widget-cmsmasters-search__container']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@aria-label='Submit Icon']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@aria-label='Featured Image']")
    private List<WebElement> newsList;

    @FindBy(xpath = "//*[@id='menu-1-5dc673f1']/li")
    private List<WebElement> navbarMainLinks;


    public void verifyNavBarItems() {

        // ana menu dogrulamalari
        for (int i = 0; i < navbarMainLinks.size(); i++) {

            assertTrue(navbarMainLinks.get(i).isDisplayed());
            assertTrue(navbarMainLinks.get(i).isEnabled());

            actions.moveToElement(navbarMainLinks.get(i)).perform();
            navbarMainLinks.get(i).click();

            String navbarMainMenuText = navbarMainLinks.get(i).getText().toLowerCase();
            String pageTitleText = driver.getTitle().toLowerCase();
            assertTrue(pageTitleText.contains(navbarMainMenuText));

            List<WebElement> dropdownMenuItems = driver.findElements(By.cssSelector(
                    "ul#menu-1-5dc673f1 > li:nth-child(" + (i + 1) + ") ul.sub-menu > li > a"));


            // alt menu dogrulamalari
            for (int j = 0; j < dropdownMenuItems.size(); j++) {

                actions.moveToElement(navbarMainLinks.get(i)).perform();
                actions.moveToElement(dropdownMenuItems.get(j)).perform();

                wait.until(ExpectedConditions.visibilityOf(dropdownMenuItems.get(j)));
                wait.until(ExpectedConditions.elementToBeClickable(dropdownMenuItems.get(j)));

                assertTrue(dropdownMenuItems.get(j).isDisplayed());
                assertTrue(dropdownMenuItems.get(j).isEnabled());

                JSUtilities.clickWithJS(driver, dropdownMenuItems.get(j));

                ReusableMethods.waitForPageToLoad(1);

                // stale element exception'ina karsi
                dropdownMenuItems = driver.findElements(By.cssSelector(
                        "ul#menu-1-5dc673f1 > li:nth-child(" + (i + 1) + ") ul.sub-menu > li > a"));

                String dropdownMenuText = dropdownMenuItems.get(j).getText().toLowerCase();
                pageTitleText = driver.getTitle().toLowerCase();
                assertTrue(pageTitleText.contains(dropdownMenuText));

            }

        }
    }


    public void printNavbarElements() {

        System.out.println(ReusableMethods.getElementTexts(navbarMainLinks));
    }


    public void searchBuuttonVisibilty() {

        assertTrue(searchButton.isDisplayed());
    }

    public void searcButtonClickability() {

        assertTrue(searchButton.isEnabled());

    }

    public void clickSearchButton() {

        searchButton.click();

    }

    public void searchFieldVisibilty() {
        ReusableMethods.hardWait(3);
        assertTrue(searchField.isDisplayed());
    }

    public void submitButtonVisibility() {

        assertTrue(submitButton.isDisplayed());
    }

    public void entersInput(String message) {
        searchField.sendKeys(message);
        actions.sendKeys(Keys.ENTER).perform();

    }

    public void selectNewsByPlaceNumber(int number) {

        ReusableMethods.hardWait(2);
        JSUtilities.scrollToElement(driver, newsList.get(number - 1));
        actions.click(newsList.get(number - 1)).perform();

    }

    public void verifyNewsPageOpens() {

        String expectedPageTitle = "İletişim";
        String actualPageTitle = driver.getTitle();

        assertTrue(actualPageTitle.contains(expectedPageTitle));


    }
}
















