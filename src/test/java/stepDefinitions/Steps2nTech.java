package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Steps2nTech extends BaseStep {



     // US003

    @And("Basvuru formunun goruntulendigini dogrular")
    public void basvuruFormununGoruntulendiginiDogrular() {

        PAGES.getFormPage().formVisibilty();
    }

    @And("KVKK metninin acilabildigini dogrular")
    public void kvkkMetnininAcilabildiginiDogrular() {

        PAGES.getFormPage().checksKvkk();



    }

    @Then("KVKK checkboxinin secili olmadigini dogrular")
    public void kvkkCheckboxininSeciliOlmadiginiDogrular() {

        PAGES.getFormPage().checkBoxSelectability();


    }

    @Then("Formun ilk sayfasini {string} {string} {string} {string} {string} {string} bilgileriyle doldurur , cvsini ekler")
    public void formunIlkSayfasiniBilgileriyleDoldurur(String name, String birthDate, String idNumber, String phoneNumber, String email, String education) {

        PAGES.getFormPage().fillingForm(name,birthDate,idNumber,phoneNumber,email,education);


    }

    @Then("Formun ikinci sayfasinda {string} secimini yapar")
    public void formunIkinciSayfasindaSeciminiYapar(String position) {

        PAGES.getFormPage().selectsPositon(position);
    }

    @And("Formu gonderebildigini dogrular")
    public void formuGonderebildiginiDogrular() {

        PAGES.getFormPage().verifiesSubmission();


    }
}
