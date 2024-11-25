package stepDefinitions;

import io.cucumber.java.en.*;
import utils.ConfigLoader;
import utils.Pages;

public class Steps2nHaber  extends  BaseStep {

    //US001

    @Given("Kullanici {string} e gider")
    public void kullanici_e_gider(String configdenUrl) {

        DRIVER.get(configLoader.getConfigValue(configdenUrl));


    }


    @Then("Navbar elementlerine tiklar , iliskili sayfalarin acildigini dogrular")
    public void navbarElementlerineTiklarIliskiliSayfalarinAcildiginiDogrular() {
        PAGES.getHomePage().verifyNavBarItems();

    }


    //US002

    @Then("Search butonu gorundugunu dogrular")
    public void searchButonuGorundugunuDogrular() {

        PAGES.getHomePage().searchBuuttonVisibilty();


    }

    @And("Tiklanabilirligini dogrular")
    public void tiklanabilirliginiDogrular() {

        PAGES.getHomePage().searcButtonClickability();


    }

    @Then("Search butonuna tiklar")
    public void searchButonunaTiklar() {
        PAGES.getHomePage().clickSearchButton();

    }

    @Then("Input alaninin acildigini dogrular")
    public void inputAlanininAcildiginiDogrular() {

        PAGES.getHomePage().searchFieldVisibilty();

    }

    @And("Submit butonu gorundugunu dogrular")
    public void submitButonuGorundugunuDogrular() {

        PAGES.getHomePage().submitButtonVisibility();


    }


    @Then("Input alanina {string} yazar")
    public void inputAlaninaYazar(String message) {

        PAGES.getHomePage().entersInput(message);


    }

    @Then("Acilan haberlerde {int} . habere tiklar")
    public void acilanHaberlerdeHabereTiklar(int placeNumber) {

        PAGES.getHomePage().selectNewsByPlaceNumber(placeNumber);


    }

    @And("Haberin acildigini dogrular")
    public void haberinAcildiginiDogrular() {

        PAGES.getHomePage().verifyNewsPageOpens();



    }



}
