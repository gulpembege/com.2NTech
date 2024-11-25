package stepDefinitions;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import pages.pages2nHaber.HomePage;
import pages.pages2nTech.FormPage;
import utils.ConfigLoader;
import utils.Driver;
import utils.Pages;

public abstract class BaseStep {

    protected final WebDriver DRIVER;

    protected static Pages PAGES;

    protected static ConfigLoader configLoader;

    protected static HomePage homePage;

    protected static FormPage formPage;

    protected static Faker faker;


    public BaseStep() {

        DRIVER = Driver.getDriver();

        PAGES = new Pages();

        configLoader=new ConfigLoader();

        homePage=new HomePage();

        formPage = new FormPage();

        faker = new Faker();

    }



}
