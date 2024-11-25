package utils;

import pages.BasePage;
import pages.pages2nHaber.HomePage;
import pages.pages2nTech.FormPage;


public class Pages extends BasePage {

	private HomePage homePage;
	private FormPage formPage;


	public Pages() {

		this.homePage = new HomePage();
		this.formPage = new FormPage();

	}

	public HomePage getHomePage() {

		return homePage;
	}

	public FormPage getFormPage(){

		return formPage;
	}


}
