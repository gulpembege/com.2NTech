package pages.pages2nTech;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.ConfigLoader;
import utils.ReusableMethods;

import java.util.List;

import static org.junit.Assert.*;

public class FormPage extends BasePage {

    @FindBy(xpath = "//*[@id='name']")
    private WebElement nameBox;

    @FindBy(xpath = "//input[@id='cv_field']")
    private WebElement cvField;

    @FindBy(xpath = "//*[@class='grid grid-cols-3 max-sm:grid-cols-2 gap-4']/button")
    private List<WebElement> educationList;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement nextArrow;

    @FindBy(xpath = "//*[@class='grid grid-cols-1 md:grid-cols-2 gap-3']/div")
    private List<WebElement> openPositions;

    @FindBy(xpath = "//*[text()='Gönder']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@class='space-y-4']")
    private WebElement form;

    @FindBy(xpath = "//*[text()='KVKK Metni']")
    private WebElement kvkk;

    @FindBy (xpath = "//*[@class='text-sm mb-6']")
    private WebElement kvkkText;

    @FindBy (xpath = "//*[@type='checkbox']")
    private WebElement kvkkCheckbox;




    public void formVisibilty(){
        assertTrue(form.isDisplayed());
    }


    public void checksKvkk(){

        assertTrue(kvkk.isDisplayed());
        assertTrue(kvkk.isEnabled());
        kvkk.click();
        assertTrue(kvkkText.isDisplayed());
        ReusableMethods.clickWithText("Kapat");


    }

    public void checkBoxSelectability(){

        assertFalse(kvkkCheckbox.isSelected());
        if (!kvkkCheckbox.isSelected()) {
            kvkkCheckbox.click();
        }

    }




    public void fillingForm(String name, String birthDate, String idNumber, String phoneNumber, String email, String education) {

        actions.click(nameBox).sendKeys(name).
                sendKeys(Keys.TAB).
                sendKeys(birthDate).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(idNumber).
                sendKeys(Keys.TAB).
                sendKeys(phoneNumber).
                sendKeys(Keys.TAB).
                sendKeys(email).perform();

        ReusableMethods.uploadFile(configLoader.getConfigValue("resume"), cvField);

        for (WebElement educations : educationList) {
            if (educations.getText().equalsIgnoreCase(education)){
                educations.click();
            }

        }

        nextArrow.click();

    }

    public void selectsPositon(String position){



        for (WebElement positions : openPositions) {
            if (positions.getText().contains(position)) {
                positions.click();
            }
        }


        ReusableMethods.hardWait(3);
        submitButton.click();




    }


    public void verifiesSubmission(){
        ReusableMethods.hardWait(4);
        assertTrue(driver.getCurrentUrl().contains("success"));
    }










}
